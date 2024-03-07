package com.springlec.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springlec.base.service.CalcService;

@Configuration

public class DataAccessClass {

	@Bean
	CalcService calcService() {
		return new CalcService() { 
			
			@Override
			public int addition(int num1, int num2) throws Exception {
				// TODO Auto-generated method stub
				return num1 + num2;
			}
			public int subtraction(int num1, int num2) throws Exception {
				// TODO Auto-generated method stub
				return num1 - num2;
			}
			public int Multiplication(int num1, int num2) throws Exception {
				// TODO Auto-generated method stub
				return num1 * num2;
			}
			public double division(int num1, int num2) throws Exception {
				// TODO Auto-generated method stub
				return num1 / num2;
			}
		};
			
	
	}
	
}
