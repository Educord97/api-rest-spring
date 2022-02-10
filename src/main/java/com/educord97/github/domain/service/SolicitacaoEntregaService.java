package com.educord97.github.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.educord97.github.domain.model.Cliente;
import com.educord97.github.domain.model.Entrega;
import com.educord97.github.domain.model.StatusEntrega;
import com.educord97.github.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private CatalogoClienteService catalogoClienteService;
	private EntregaRepository entregaRepository;
	
	public Entrega solicitar(Entrega entrega) {
		   Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		 
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDETE);
		entrega.setDataPedido(OffsetDateTime.now());
		return entregaRepository.save(entrega);
	}
}
