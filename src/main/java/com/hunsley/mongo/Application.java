package com.hunsley.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "colosseum-snacks-service")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
