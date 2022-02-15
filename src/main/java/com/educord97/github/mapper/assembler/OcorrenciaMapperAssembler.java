package com.educord97.github.mapper.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.educord97.github.domain.model.Ocorrencia;
import com.educord97.github.model.dto.OcorrenciaDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaMapperAssembler {

	private ModelMapper modelMapper;
	
	public OcorrenciaDTO toDTO(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
	}
	
	public List<OcorrenciaDTO> toCollectionDTO(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}
}
