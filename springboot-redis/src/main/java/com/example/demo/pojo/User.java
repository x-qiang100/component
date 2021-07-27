package com.example.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@NoArgsConstructor
@Data
public class User implements Serializable{

    private String name;
    private int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
