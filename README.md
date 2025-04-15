# Backend - Microsserviço Java (Spring Boot 3 + Java 21)

Este repositório contém o backend da aplicação, construído com Spring Boot 3 e Java 21.

## ✅ Requisitos

- Java 21
- Maven
- Docker

## 🚀 Como construir a imagem Docker

```bash
docker build -t danielteotonio/listaDeTarefas-back .
```

▶️ Como executar a imagem
```bash
docker run -p 8081:8081 \
  -e SERVER_PORT=8081 \
  -e DB_URL=jdbc:postgresql://db:5432/postgres \
  danielteotonio/listaDeTarefas-back
```
