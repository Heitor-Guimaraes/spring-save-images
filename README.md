# Spring Save Images

Exemplo de API em Java e Spring Boot para cadastro de usuário com upload de foto. O arquivo enviado é salvo em disco com um nome único (UUID) e o usuário é persistido no MySQL.

## Tecnologias

Java 25 · Spring Boot 4 (Web MVC, Validation) · Spring Data JPA / Hibernate · MySQL · Lombok · Maven

## Endpoint

| Método | Rota | Descrição |
|---|---|---|
| POST | /user/cadastrar | Cadastra o usuário e salva a foto enviada (multipart) |

## Estrutura

UserController recebe a requisição, PhotoService grava o arquivo no diretório de upload e UserService persiste o usuário pelo UserRepository.

## Como executar

Pré-requisitos: Java 25, Maven e MySQL.

Ajuste as credenciais do banco e o diretório de upload em src/main/resources/application.properties e execute ./mvnw spring-boot:run.

## Autor

Heitor Guimarães Perciliano · [LinkedIn](https://www.linkedin.com/in/heitor-perciliano/)
