package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class MyFirstBlogDemo {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstBlogDemo.class, args);
    }

//    @PostConstruct
//    void started() {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//    }


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        return new HiddenHttpMethodFilter();
    }

}
