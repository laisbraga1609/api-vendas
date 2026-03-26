# API de Vendas

Projeto desenvolvido com Spring Boot.

## Funcionalidades

- Criar venda
- Listar vendas
- Resumo de vendas por vendedor

## Tecnologias

- Java
- Spring Boot
- H2 Database
- # API de Vendas - Spring Boot

## 🚀 Funcionalidades

- Criar uma nova venda
- Listar todas as vendas
- Criar vendas em lote (extra)
- Retornar resumo de vendas por vendedor, contendo:
  - Nome do vendedor
  - Total de vendas no período
  - Média de vendas diária

## 🛠️ Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Banco de dados H2 (em memória)
- Maven

## 📌 Endpoints

### ➤ Criar vendas em lote
POST `/api/vendas/lote`

### ➤ Listar vendas
GET `/api/vendas`

### ➤ Resumo por período
GET `/api/vendas/resumo?inicio=YYYY-MM-DD&fim=YYYY-MM-DD`

## 🧠 Regra de negócio

O resumo agrupa as vendas por vendedor e calcula:
- Total de vendas no período
- Média diária (total dividido pelo número de dias)

## ▶️ Como rodar o projeto

1. Clonar o repositório
2. Abrir na IDE (Eclipse ou IntelliJ)
3. Rodar a aplicação
4. Acessar:
   - API: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console

## 📊 Exemplo de requisição

```json
[
  {
    "dataVenda": "2026-03-25",
    "valor": 100.0,
    "vendedorId": 1,
    "vendedorNome": "Miguel"
  },
  {
    "dataVenda": "2026-03-26",
    "valor": 200.0,
    "vendedorId": 2,
    "vendedorNome": "Felipe"
  }
]
