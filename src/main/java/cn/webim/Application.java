package cn.webim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "cn.webim")
@EnableJpaRepositories(basePackages = "cn.webim.service")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}