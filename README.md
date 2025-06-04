<img src="https://raw.githubusercontent.com/github/explore/main/topics/spring-boot/spring-boot.png" width="100" alt="Programa de Fidelidade"/>

# Programa de Fidelidade para Supermercado

Este projeto é um MVP de um sistema de fidelidade para um supermercado de médio porte.  
O objetivo é aumentar a retenção de clientes e coletar dados sobre seus hábitos de compra.

## 🎯 Funcionalidades

- Cadastro de usuários interessados
- Emissão de pontos com base em compras
- Consulta de saldo de pontos acumulados

## 🧱 Arquitetura

- **Java 17**
- **Spring Boot**
- **MySql**
- **Clean Architecture + DDD**
- **Swagger**
- **Docker**
- **Monitoramento com Prometheus e Grafana**

## 🚀 Como executar localmente

### Pré-requisitos

- Docker
- Java 17
- Maven

## Acesse a documentação da API via Swagger em:
- http://localhost:8080/swagger-ui/index.html#/
- usuario: username
- senha: password

## 🧪 Testes
 - Para executar todos os testes:
   ```bash
   # Executar comando abaixo localmente
   ./mvnw test

## 📂 Estrutura do projeto
 - src/main/java/br/com/supermercado/fidelidade/aplicacao: Casos de uso (Application Layer)
 - src/main/java/br/com/supermercado/fidelidade/dominio: Entidades e regras de negócio (Domain Layer)
 - src/main/java/br/com/supermercado/fidelidade/infra: Repositórios, adaptadores e integrações (Infra Layer)
 - src/main/java/br/com/supermercado/fidelidade/interfaces: Controllers e APIs REST (Interface Layer)

## Visão macro da arquitetura do sistema
![Diagrama de Arquitetura](imagens/visao_macro.png)

## 👤 Autor
Fábio Borsato Morais

### Comandos

```bash
# Subir o ambiente com banco e serviços
docker run --detach --env MYSQL_ROOT_PASSWORD=password --env MYSQL_USER=user-fidelidade --env MYSQL_PASSWORD=password --env MYSQL_DATABASE=fidelidade --name mysql --publish 3306:3306 mysql:8-oracle

# Executar aplicação localmente
./mvnw spring-boot:run
