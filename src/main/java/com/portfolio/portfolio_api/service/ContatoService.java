package com.portfolio.portfolio_api.service;

import com.portfolio.portfolio_api.entity.Contato;
import com.portfolio.portfolio_api.exception.ContactLimitExceededException;
import com.portfolio.portfolio_api.exception.EmailAlreadyExistsException;
import com.portfolio.portfolio_api.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContatoService {
  public final ContatoRepository contatoRepository;

  private static final int DEFAULT_MAX_CONTACTS_PER_EMAIL = 3;

  @Transactional
  public Contato create(Contato contato) {
    return create(contato, DEFAULT_MAX_CONTACTS_PER_EMAIL);
  }
  @Transactional
  public Contato create(Contato contato, int maxContactsPerEmail) {
    int count = contatoRepository.countByEmail(contato.getEmail());

    if (count >= maxContactsPerEmail) {
      if (maxContactsPerEmail == 1) {
        throw new EmailAlreadyExistsException("Email já cadastrado!");
      } else {
        throw new ContactLimitExceededException("Limite de " + maxContactsPerEmail + " contatos atingido para este email!");
      }
    }

    contato.setCreatedAt(LocalDateTime.now());
    return contatoRepository.save(contato);
  }
}
