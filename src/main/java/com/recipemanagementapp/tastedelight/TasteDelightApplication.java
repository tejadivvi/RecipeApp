package com.recipemanagementapp.tastedelight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@springfox.documentation.swagger2.annotations.EnableSwagger2
public class TasteDelightApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasteDelightApplication.class, args);
    }

}