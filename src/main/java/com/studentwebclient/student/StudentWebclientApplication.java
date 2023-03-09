package com.studentwebclient.student;

import java.awt.PageAttributes.MediaType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.studentwebclient.student.model.Student;

import io.netty.handler.codec.http.HttpHeaders;
import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequestMapping("/StudentWebclientApplication")
public class StudentWebclientApplication {
	
	WebClient webclient;
	
	@PostConstruct
	public void init() {
		webclient = WebClient.builder().baseUrl("http://localhost:8085/api/auth").
				    defaultHeader(org.springframework.http.HttpHeaders.CONTENT_TYPE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE).
				    build();
	}

	@PostMapping("/createStudent")
	public Mono<String> createStudent(@RequestBody Student student){
		return webclient.
				post().
				uri("/student").
				bodyValue(student).
				retrieve().
				bodyToMono(String.class);
	}
	
	@GetMapping("/getStudentsDetail")
	public Flux<Student> trackallstudents(){
		return webclient.
				get().
				uri("/students").
				retrieve().
				bodyToFlux(Student.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StudentWebclientApplication.class, args);
	}

}
