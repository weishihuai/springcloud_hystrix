package com.springcloud.wsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudHystrixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudHystrixEurekaServerApplication.class, args);
	}
}
