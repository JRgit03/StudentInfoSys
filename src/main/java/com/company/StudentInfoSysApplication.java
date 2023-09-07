package com.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.company.mapper"})
public class StudentInfoSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentInfoSysApplication.class, args);
	}

}
