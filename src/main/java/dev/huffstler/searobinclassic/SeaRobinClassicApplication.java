package dev.huffstler.searobinclassic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = { "dev.huffstler.searobinclassic.controller" })
@SpringBootApplication
public class SeaRobinClassicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeaRobinClassicApplication.class, args);
	}

}
