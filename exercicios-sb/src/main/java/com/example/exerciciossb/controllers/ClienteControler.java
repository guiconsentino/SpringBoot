package com.example.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exerciciossb.model.entities.Cliente;
@RestController
@RequestMapping("/clientes")
public class ClienteControler {

	@GetMapping(path = "/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28, "Pedro", "123.456.789-00");
	}

	//primeira forma para passar um valor a partir da requisição para dentro do metodo
	// ou seja o metodo receber parametros pela url!!
	//nao é a forma padrão de se passar parametro através de uma requisição do tipo get
	
	@GetMapping("/{id}")//entre par de chaves para dizer que é uma variavel
	public Cliente obterClientePorid1(@PathVariable int id) {
		return new Cliente(id, "Guilherme", "234.348.786-01");
		
	}

	@GetMapping
	public Cliente obteClientePorid2(@RequestParam(name = "id", defaultValue = "1") int id) {
		return new Cliente(id, "Karina", "449.998.756-02");
	}
	

}
