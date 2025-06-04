![Programa de Fidelidade](https://raw.githubusercontent.com/github/explore/main/topics/spring-boot/spring-boot.png)

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

### Comandos

```bash
# Subir o ambiente com banco e serviços
docker-compose up

# Executar aplicação localmente
./mvnw spring-boot:run
