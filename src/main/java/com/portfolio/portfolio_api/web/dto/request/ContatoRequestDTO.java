package com.portfolio.portfolio_api.web.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoRequestDTO {
  @NotBlank
  private String name;

  @NotBlank
  @Email(message = "Formato do e-mail é inválido!", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
  private String email;

  @NotBlank
  private String message;
}
