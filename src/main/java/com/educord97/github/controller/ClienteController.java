package com.educord97.github.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educord97.github.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		
		cliente1.setId(1L);
		cliente1.setNome("Eduardo");
		cliente1.setTelefone("999");
		cliente1.setEmail("eduardo@gmail.com");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("PEDRo");
		cliente2.setTelefone("555");
		cliente2.setEmail("pedro@gmail.com");
		
		return Arrays.asList(cliente1, cliente2);
	}

}
