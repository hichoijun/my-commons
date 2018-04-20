package com.cai.websocketspring;

import com.cai.websocketspring.config.ITest;
import com.cai.websocketspring.config.TestImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class WebsocketSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketSpringApplication.class, args);
	}
}
