package com.example.sanstrick;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.sanstrick.entity") // Specify the package where your entities are located
public class SanstrickApplication {
    public static void main(String[] args) {
        SpringApplication.run(SanstrickApplication.class, args);
    }
}
