# Weather API

Esta é uma API para gerenciar dados climáticos e eventos climáticos extremos, desenvolvida com Spring Boot. A API permite que os usuários consultem o clima atual, previsões do tempo, gerenciem eventos climáticos extremos e façam comentários sobre o clima.

## Funcionalidades

- Consulta de dados climáticos atuais por cidade.
- Exibição do histórico de condições climáticas de uma cidade.
- Previsão do tempo para os próximos dias.
- Gerenciamento de eventos climáticos extremos (criar, visualizar, deletar).
- Comentários de usuários sobre o clima atual em suas cidades (criar, visualizar, editar, deletar).

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Hibernate (JPA)
- MySQL
- Maven

## Pré-requisitos

- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/) (pode ser gerenciado via [phpMyAdmin](https://www.phpmyadmin.net/))
- [Git](https://git-scm.com/)

## Configuração e Execução

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/weather-api.git
cd weather-api

spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco_de_dados?useSSL=false&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

mvn clean install
mvn spring-boot:run


### Conclusão

Esse `README.md` fornece uma descrição clara de como configurar, executar e testar a API. Ele pode ser ajustado conforme necessário para incluir mais detalhes específicos do seu projeto. Se precisar de mais alguma coisa, estou à disposição!
