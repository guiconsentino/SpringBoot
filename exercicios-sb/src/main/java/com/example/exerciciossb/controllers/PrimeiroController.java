package com.example.exerciciossb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	//primeiro webservice criado
	@RequestMapping
	public String ola() {
		return "olá Spring Boot";
	}
	
	/*
	@RequestMapping(method = RequestMethod.GET, path = "/ola")
	public String ola() {
		return "olá Spring boot";
	 }
	
	@GetMapping(path = "/ola")
	public String ola() {
		return "olá Spring boot";
	}
				path = array de strings
	@GetMapping(path = {"/ola", "/saudacao"}) um array de dados para usar mais de uma url
	public String ola() {
		return "olá Spring boot";
	}*/
}
