package com.example.demo.vm.vo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "book.default")
public class DefaultBook {
    private String name;
    private String author;
    private String age;
    private String scope;
}
