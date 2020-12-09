package com.example.demo.DBConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource( value = "file:${user.home}/env/config.properties", ignoreResourceNotFound = true), //리눅스 서버용
        @PropertySource( value = "file:c:/dev/config.properties", ignoreResourceNotFound = true )           //윈도우 테스트용
})
public class GlobalPropertySource {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
