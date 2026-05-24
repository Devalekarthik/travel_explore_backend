package com.travel.backend.controller;

import java.time.Instant;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/api/hello")
	public Map<String, Object> hello() {
		return Map.of(
			"message", "Hello from travel_explore_backend",
			"timestamp", Instant.now().toString()
		);
	}
}
