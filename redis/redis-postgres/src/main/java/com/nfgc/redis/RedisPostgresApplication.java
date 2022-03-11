package com.nfgc.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisPostgresApplication.class, args);
	}

}
