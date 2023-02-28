package com.huffstler.SRCServer;

import com.huffstler.SRCServer.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SRCServerApplication {
	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SRCServerApplication.class, args);
		checkBeansPresence();
	}

	private static void checkBeansPresence(String... beans) {
		System.out.println("FIND ME");
		Arrays.stream(applicationContext.getBeanDefinitionNames()).filter(s-> s.contains("huffstler")).forEach(System.out::println);
	}

	@Bean
	public MainService initMainService(){
		return new MainService();
	}

}
