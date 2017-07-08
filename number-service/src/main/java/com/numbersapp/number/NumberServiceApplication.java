package com.numbersapp.number;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sepulrator on 08.07.2017.
 */
@EnableDiscoveryClient
@EnableConfigurationProperties
@SpringBootApplication
public class NumberServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NumberServiceApplication.class, args);
    }

}
