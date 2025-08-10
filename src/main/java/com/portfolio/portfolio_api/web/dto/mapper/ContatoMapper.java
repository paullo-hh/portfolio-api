package com.portfolio.portfolio_api.web.dto.mapper;

import com.portfolio.portfolio_api.entity.Contato;
import com.portfolio.portfolio_api.web.dto.request.ContatoRequestDTO;
import com.portfolio.portfolio_api.web.dto.response.ContatoResponseDTO;
import org.modelmapper.ModelMapper;

import java.util.*;
import java.util.stream.*;

public class ContatoMapper {
  public static Contato toContato(ContatoRequestDTO contatoRequestDTO) {
    return new ModelMapper().map(contatoRequestDTO, Contato.class);
  }

  public static ContatoResponseDTO toDto(Contato contato) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(contato, ContatoResponseDTO.class);
  }

  public static List<ContatoResponseDTO> toListDto(List<Contato> contatos) {
    return contatos.stream().map(ContatoMapper::toDto).collect(Collectors.toList());
  }
}
