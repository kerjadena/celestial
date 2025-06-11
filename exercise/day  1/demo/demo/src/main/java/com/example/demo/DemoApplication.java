package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/hello")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/world")
	public String getHello(@RequestParam(defaultValue = "World") String name) {
		return "Hello, " + name + "!";
	}
	@PostMapping
	public String postHello(@RequestBody HelloRequest request){
		return String.format("Hello updated to %s!", request.getName());
	}
	@PutMapping
	public String putHello(@RequestBody HelloRequest request){
		return String.format("Hello updated to %s!", request.getName());
	}
	@DeleteMapping
	public String deleteHello(@RequestParam String name) {
		return String. format ("Hello deleted for %s!", name);
		}
}
