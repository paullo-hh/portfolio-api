# Portfolio API

Esta é a minha API REST pessoal para gerenciamento de portfólio.  
Uso este projeto como vitrine das minhas habilidades técnicas e como laboratório para testar e aprofundar meus conhecimentos em backend, explorando recursos modernos do ecossistema Spring.

## Motivação

Desenvolvi esta API para fortalecer minha experiência com APIs REST e arquitetura backend.  
Escolhi trabalhar sobre um domínio simples, mas com implementação robusta, para focar nas melhores práticas de desenvolvimento e manter um código limpo, escalável e fácil de manter.

## Stack Tecnológica

### Core
- **Java 21** – Versão LTS mais recente, aproveitando recursos modernos da linguagem.
- **Spring Boot 3.5.4** – Framework principal para desenvolvimento rápido e robusto.
- **Maven** – Gerenciamento de dependências e build.

### Persistência
- **Spring Data JPA** – Abstração para acesso a dados.
- **MySQL** – Banco de dados relacional para persistência.
- **Hibernate** – ORM com geração automática de schema em ambiente de desenvolvimento.

### Segurança e Validação
- **Spring Security** – Implementação de autenticação e autorização.
- **Bean Validation** – Validação robusta de dados de entrada.

### Ferramentas e Bibliotecas
- **Lombok** – Redução de boilerplate code.
- **ModelMapper** – Mapeamento entre DTOs e entidades.
- **SpringDoc OpenAPI** – Documentação automática com Swagger UI.
- **dotenv-java** – Carregamento seguro de variáveis de ambiente.

## Decisões Arquiteturais

### Configurações Personalizadas
- **Timezone**: Configurei o timezone padrão como `America/Sao_Paulo` para manter consistência temporal.
- **Variáveis de Ambiente**: Implementei carregamento automático de variáveis via `.env` para facilitar ajustes sem alterar o código.
- **OpenAPI**: Personalizei a documentação com minhas informações de contato e licenciamento.

### Estrutura de Camadas
Organizei o projeto seguindo princípios da Clean Architecture:
- **Controllers** – Camada de apresentação REST.
- **Services** – Lógica de negócio.
- **Repositories** – Acesso a dados.
- **Entities/DTOs** – Modelos de domínio e transferência de dados.

## Documentação

A documentação da API está disponível via Swagger UI em `/docs-portfolio.html` quando a aplicação está rodando.

## Sobre mim

**Paulo Henrique S Carvalho**
contato.paulocarvalho@gmail.com

---

*Este projeto é parte da minha jornada de evolução como desenvolvedor backend, aplicando práticas sólidas de arquitetura, organização e uso criterioso de tecnologias atuais.*
