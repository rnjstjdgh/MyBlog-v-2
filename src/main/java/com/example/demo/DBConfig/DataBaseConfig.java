package com.example.demo.DBConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    @Autowired
    GlobalPropertySource globalPropertySource;

    @Bean
    @Primary
    public DataSource customDataSource(){
        return DataSourceBuilder
                .create()
                .url(globalPropertySource.getUrl())
                .username(globalPropertySource.getUsername())
                .password(globalPropertySource.getPassword())
                .build();
    }

}
