package com.dh.catalog;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableRabbit
@EnableFeignClients
@EnableDiscoveryClient
public class ApiCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCatalogApplication.class, args);
    }

}
