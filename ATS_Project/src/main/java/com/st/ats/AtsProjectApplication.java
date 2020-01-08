package com.st.ats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AtsProjectApplication {
  	
	@Bean
	public RestTemplate template() {
		RestTemplate  template=new RestTemplate();
		return template;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(AtsProjectApplication.class, args);
	}
}
