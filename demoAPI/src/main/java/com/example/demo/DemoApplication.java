package com.example.demo;
import com.example.demo.Hexagon.Hexagon;
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
		Hexagon2 hexagon2 = new Hexagon2(15,20);
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

	@CrossOrigin
	@GetMapping("/hexagon")
	public List<Hexagon> hexagons() {return  List.of(new Hexagon(10,15));}
//	public String generateHexagonalGridJson(int n) throws JsonProcessingException {
//		List<Hexagon> hexagons = new ArrayList<>();
//		for (int q = -n + 1; q < n; q++) {
//			int r1 = Math.max(-n + 1, -q - n + 1);
//			int r2 = Math.min(n - 1, -q + n - 1);
//			for (int r = r1; r <= r2; r++) {
//				hexagons.add(new Hexagon(q, r));
//			}
//		}
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.writeValueAsString(hexagons);
//	}

}
//
//@Data
//class test{
//	private int lol;
//}
