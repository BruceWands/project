package com.orange;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.orange.dao")
@Controller
public class Demo2Application {
	@RequestMapping("/hh.do")
	String he(){
		return "../../index";
	}
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
}
