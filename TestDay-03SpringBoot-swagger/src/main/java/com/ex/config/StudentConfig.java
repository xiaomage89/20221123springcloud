package com.ex.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ex.dto.StudentDto;

@Configuration
public class StudentConfig {
	
	@Bean
	public StudentDto getStudent(){
		return new StudentDto("小马",1400,"一班");
	}
	
	
}
