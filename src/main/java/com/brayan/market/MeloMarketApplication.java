package com.brayan.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MeloMarketApplication {

	public static void main(String[] args) { SpringApplication.run(MeloMarketApplication.class, args); }

}
