package org.tuma;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.tuma.dao.mapper")
public class Tuma01ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tuma01ServerApplication.class, args);
    }

}
