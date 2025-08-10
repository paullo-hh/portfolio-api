package com.portfolio.portfolio_api.web.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoResponseDTO {
  private Long id;
  private String name;
  private String email;
  private String message;
}
