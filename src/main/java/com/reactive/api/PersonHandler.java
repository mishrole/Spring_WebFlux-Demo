package com.reactive.api;

import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* Functional */

@Component
public class PersonHandler {
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(Flux.fromIterable(Arrays.asList(new Person(1, "Person A"), new Person(2, "Person B"))), Person.class);
	}
}
