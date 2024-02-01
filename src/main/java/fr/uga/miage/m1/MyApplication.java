package fr.uga.miage.m1;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Log
public class MyApplication{

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }
}
