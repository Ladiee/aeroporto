package com.ladielma.aeroporto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication //Combina as três abaixo

// @Configuration - Permite a criação dos bins
// @EnableAutoConfiguration - Permite a configuração automática do spring
// @ComponentScan - Permite que o spring escaneie todo o projeto
public class AeroportoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeroportoApplication.class, args);
	}

}
