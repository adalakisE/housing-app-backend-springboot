package com.adalakise.housingapp;

import com.adalakise.housingapp.demodata.DemoDataLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HousingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousingAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner createModelData(DemoDataLoader loader) {
        return args -> loader.createDemoData();
    }


}
