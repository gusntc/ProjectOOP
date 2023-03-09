package com.example.demo;
import com.example.demo.Profile.Profile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.DataAmount;
//import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController()
@RequestMapping(path="/api", produces="application/json")
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@CrossOrigin
	@GetMapping("/hex2")
	public List<List<Integer>> Hex2(){
		Hexagon2 hexagon2 = new Hexagon2(5,16);
		return hexagon2.getGrid();
	}

//	@GetMapping("/test")
//	public  test test(){
//		test t = new test();
//		t.setLol(5);
//		return t;
//	}
	@CrossOrigin
	@GetMapping("/profile")
	public List<Profile> profiles(){
		return List.of(new Profile("Sakura" , 300 , 6000));
	}

}
//
//@Data
//class test{
//	private int lol;
//}
