# Projeto em desenvolvimento

# Gerenciador de Partidas de Futebol Amador - API

Este projeto é uma aplicação para o gerenciamento de partidas de futebol amador, com backend desenvolvido em **Spring Boot**. O sistema permite organizar partidas de fim de semana, com equipes que podem ser selecionadas manualmente ou distribuídas aleatoriamente, de acordo com a necessidade.

## Estrutura do Projeto

- **Backend**: Spring Boot
  - Conecta ao banco de dados (H2) e utiliza Hibernate para manipulação de entidades e relacionamentos.
  - Exemplo de modelagem de entidades: `Partida`, `Jogador`, `Time`.
  - Configuração de persistência e transações para gerenciar as inserções de jogadores nas partidas.

## Tecnologias Utilizadas

- **Backend**:
  - [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
  - [Spring Boot](https://spring.io/projects/spring-boot)
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
  - [Hibernate](https://hibernate.org/)
  - [Banco de dados H2](https://www.h2database.com/)

## Requisitos de Instalação

- **Java 17+**
- **Maven**

## Configuração do Banco de Dados

O projeto usa um banco de dados H2 embutido, configurado no `application.properties`. Para alterar o banco de dados, edite as configurações de conexão conforme necessário.

Arquivo `application.properties` exemplo:

```properties
#=================================================
# PARAMETROS DA APLICAÇÃO
#=================================================
spring.application.name=Gerenciador de Peladas
server.port=8082

#=================================================
# PARAMETROS DO JPA
#=================================================
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true

#=================================================
# PARAMETROS DO BANCO DE DADOS - H2
#=================================================
spring.datasource.url=jdbc:h2:file:~/test
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
```

## Checklist - Atividades

### Configuração Inicial
- [x] Configurar projeto Spring Boot.
- [x] Configurar dependências do Maven:
  - [x] Spring Web.
  - [x] Spring Data JPA.
  - [x] Banco de dados H2.
- [x] Configurar banco de dados H2 no `application.properties`.

### Modelagem do Banco de Dados e Entidades
- [x] Criar entidade `Partida`.
  - [x] Campos: `id`, `data`, `local`, etc.
- [x] Criar entidade `Jogador`.
  - [x] Campos: `id`, `nome`, `idade`, etc.
- [x] Criar entidade `Time`.
  - [x] Campos: `id`, `nome`, `jogadores`, etc.
- [x] Definir relacionamentos entre as entidades:
  - [x] Configurar relacionamento `@ManyToMany` entre `Partida` e `Jogador`.
  - [x] Configurar relacionamento `@OneToMany` ou `@ManyToOne` para associar `Jogador` ao `Time`.

### Repositórios (Repositories)
- [x] Criar `PartidaRepository`.
- [x] Criar `JogadorRepository`.
- [x] Criar `TimeRepository`.

### Serviços (Services)
- [x] Criar serviço `PartidaService` para gerenciar lógica de negócio das partidas.
  - [x] Implementar método para criar nova partida.
  - [x] Implementar método para listar partidas.
- [x] Criar serviço `JogadorService` para gerenciar lógica de negócio dos jogadores.
  - [x] Implementar método para adicionar novo jogador.
  - [x] Implementar método para listar jogadores.
- [ ] Criar serviço `TimeService` para gerenciar lógica de negócio dos times.
  - [ ] Implementar método para criar novo time.
  - [ ] Implementar método para listar times.

### Controladores (Controllers)
- [x] Criar controlador `PartidaController`.
  - [x] Endpoint para criar nova partida.
  - [x] Endpoint para listar partidas.
- [x] Criar controlador `JogadorController`.
  - [x] Endpoint para adicionar novo jogador.
  - [x] Endpoint para listar jogadores.
- [ ] Criar controlador `TimeController`.
  - [ ] Endpoint para criar novo time.
  - [ ] Endpoint para listar times.

### Validações e Regras de Negócio
- [ ] Validar dados de entrada para criação de jogador.
- [ ] Validar dados de entrada para criação de partida.
- [ ] Validar dados de entrada para criação de time.
- [ ] Verificar regras de negócio para associação de jogadores a uma partida (evitar duplicidades).

### Testes
- [ ] Criar testes unitários para `PartidaService`.
- [ ] Criar testes unitários para `JogadorService`.
- [ ] Criar testes unitários para `TimeService`.
- [ ] Criar testes de integração para os controladores (endpoints).

### Documentação da API
- [ ] Configurar Swagger para documentação da API.
- [ ] Documentar endpoints e parâmetros no Swagger.

### Finalização e Deploy
- [ ] Revisar e otimizar código.
- [ ] Configurar profiles (`dev`, `prod`) no `application.properties`.
- [ ] Preparar instruções para deploy.

---

Esse checklist será atualizado à medida que o desenvolvimento do backend progredir. Marque cada item conforme for concluído para acompanhar o progresso do projeto.

