package com.example.demo.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@SequenceGenerator(name = "USER_SEQ_GENERATOR", sequenceName = "USER_SEQ", initialValue = 1, allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE , generator="USER_SEQ_GENERATOR")
    private Long id;

    @Column(length = 20, nullable = false , unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;
}
