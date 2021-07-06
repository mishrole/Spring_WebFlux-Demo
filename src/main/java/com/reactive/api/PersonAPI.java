package com.reactive.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/* Traditional (old school) */

@RestController
@RequestMapping("/v1/person")
public class PersonAPI {
	
	@GetMapping
	public Flux<Person> findAll() {
		List<Person> list = Arrays.asList(new Person(1, "Person A"), new Person(2, "Person B"), new Person(3, "Person C"));
		Flux<Person> fx = Flux.fromIterable(list);
		return fx;
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> deleteById(@PathVariable("id") Integer id) {
		return getPerson().
				flatMap(p -> Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
	}
	
	private Mono<Person> getPerson() {
		return Mono.just(new Person(1, "Person A"));
	}
	
}
