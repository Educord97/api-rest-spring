package com.educord97.github.mapper.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.educord97.github.domain.model.Entrega;
import com.educord97.github.model.dto.EntregaDTO;
import com.educord97.github.model.dto.input.EntregaInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapperAssembler {

	private ModelMapper modelMapper;
	
	public EntregaDTO toDTO(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	}
	
	public List<EntregaDTO> toCollectionDTO(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
	
	
}
