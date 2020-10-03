package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Saludos desde %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/saludo")
	public Greeting greeting(@RequestParam(value = "desde", defaultValue = "Puente Alto") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
