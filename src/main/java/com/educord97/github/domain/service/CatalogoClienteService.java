package com.educord97.github.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.educord97.github.domain.exception.NegocioException;
import com.educord97.github.domain.model.Cliente;
import com.educord97.github.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clientId) {
		clienteRepository.deleteById(clientId);
	}
}
