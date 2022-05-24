package com.example.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@GetMapping("/somar/{a}/{b}")
	//somar/10/20 ... exemplo
	public int somar(@PathVariable int a,@PathVariable int b) {
		return a + b;
	}
	@GetMapping("/subtrair")
	//subtrair?a=100&b=30... exemplo	
	public int subtrair(@RequestParam(name = "a") int a,
						@RequestParam(name = "b") int b) {
		return a - b;
	}
	
}
