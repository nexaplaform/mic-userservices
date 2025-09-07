package com.fiverr.app.mic.userservices;

import org.springframework.boot.SpringApplication;

public class TestMicUserservicesApplication {

	public static void main(String[] args) {
		SpringApplication.from(MicUserservicesApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
