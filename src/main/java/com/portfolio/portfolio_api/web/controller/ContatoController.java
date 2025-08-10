package com.portfolio.portfolio_api.web.controller;

import com.portfolio.portfolio_api.entity.Contato;
import com.portfolio.portfolio_api.service.ContatoService;
import com.portfolio.portfolio_api.web.dto.mapper.ContatoMapper;
import com.portfolio.portfolio_api.web.dto.request.ContatoRequestDTO;
import com.portfolio.portfolio_api.web.dto.response.ContatoResponseDTO;
import com.portfolio.portfolio_api.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Contatos", description = "Recursos para o gerenciamento dos contatos.")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/contatos")
public class ContatoController {
  private final ContatoService contatoService;

  @Operation(
      summary = "Cadastra um novo contato",
      description = "Recurso para cadastro de um novo contato.",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "Contato cadastrado com sucesso!",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(
                      implementation = ContatoResponseDTO.class
                  )
              )
          ),
          @ApiResponse(
              responseCode = "409",
              description = "Contato já cadastrado!",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(
                      implementation = ErrorMessage.class
                  )
              )
          ),
          @ApiResponse(
              responseCode = "422",
              description = "Cadastro não processado por dados de entrada inválidos!",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(
                      implementation = ErrorMessage.class
                  )
              )
          )
      }
  )
  @PostMapping
  public ResponseEntity<ContatoResponseDTO> create(@Valid @RequestBody ContatoRequestDTO contatoRequestDTO) {
    Contato contato = contatoService.create(ContatoMapper.toContato(contatoRequestDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(ContatoMapper.toDto(contato));
  }
}
