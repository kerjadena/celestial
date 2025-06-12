package io.reflectoring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
	@GetMapping("/world")
	public String getBook(@RequestParam(defaultValue = "World") String name) {
		return "Hello, " + name + "!";
	}
	@PostMapping
	public String postBook(@RequestBody BookRequest request){
		return String.format("Hello updated to %s!", request.getName());
	}
	@PutMapping
	public String putBook(@RequestBody BookRequest request){
		return String.format("Hello updated to %s!", request.getName());
	}
	@DeleteMapping
	public String deleteBook(@RequestParam String name) {
		return String. format ("Hello deleted for %s!", name);
	}
}
