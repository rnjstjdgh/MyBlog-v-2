package com.example.demo.User;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/CSS/**", "/JS/**", "/img/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 페이지 권한 설정
                .antMatchers("/Admin/**").hasRole("ADMIN")
                .antMatchers("/Content/ContentCreate/**").hasRole("ADMIN")
                .antMatchers("/Content/ContentModify/**").hasRole("ADMIN")
                .antMatchers("/Content/ContentDelete/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                // 로그인 설정
                .formLogin()
                .loginPage("/User/Login")
                .failureUrl("/User/Login?error")
                .defaultSuccessUrl("/")         //로그인 성공 url====> 메인으로 이동!
                .permitAll()
                .and() // 로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/User/Logout"))
                .logoutSuccessUrl("/")		//로그아웃시=========> 메인으로 이동!
                .invalidateHttpSession(true)
                .and()
                // 403 예외처리 핸들링(접근권한이 없는 페이지를 접근하면 일로 보내버림)
                .exceptionHandling().accessDeniedPage("/User/Denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}