package com.recipemanagementapp.tastedelight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.recipemanagementapp.tastedelight")
@org.springframework.context.annotation.ComponentScan(basePackages = "com.recipemanagementapp.tastedelight")
public class TasteDelightApplication {

    public static void main(String[] args) {
        SpringApplication.run(TasteDelightApplication.class, args);
    }

}