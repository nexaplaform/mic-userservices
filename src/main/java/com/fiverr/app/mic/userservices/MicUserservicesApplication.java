package com.fiverr.app.mic.userservices;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {
        @Server(url = "/", description = "Default Server"),
        @Server(url = "https://mic-userservices-production.up.railway.app/", description = "Production Server")
})
public class MicUserservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicUserservicesApplication.class, args);
	}

}
