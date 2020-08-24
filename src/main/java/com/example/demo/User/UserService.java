package com.example.demo.User;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Transactional
    public UserEntity findUserByUserName(String userName){
        Optional<UserEntity> userEntitywrpper = userRepository.findByEmail(userName);
        if(!userEntitywrpper.isPresent()){
            System.out.println("회원을 찾을수 없습니다!");
            return null;
        }
        else
            return userEntitywrpper.get();
    }

    @Transactional
    public Long emailOverlapCheck(String email) {
        if(userRepository.findByEmail(email).isPresent())
            return new Long(-1);
        else
            return new Long(1);
    }

    //회원가입
    @Transactional
    public Long joinUser(UserEntity userEntity) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        //아이디 중복시  -1반환
        if(userRepository.findByEmail(userEntity.getEmail()).isPresent())
            return new Long(-1);

        //성공적으로 회원가입 완료시 그 회원의 아이디 반환(>=1)
        return userRepository.save(userEntity).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityWrapper = userRepository.findByEmail(userEmail);
        if(!userEntityWrapper.isPresent())
            throw new UsernameNotFoundException("아이디를 찾을 수 없습니다.");
        UserEntity userEntity = userEntityWrapper.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("rnjstjdgh").equals(userEmail)) {	//권한설정을 내꺼 하나만 admin으로
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }
//        else {
//            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
//        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }
}
