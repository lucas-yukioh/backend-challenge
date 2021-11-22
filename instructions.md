# Backend Challenge
Repositório contendo API para o desafio de Backend.

## Tecnologias Utilizadas
- Java 11
- Maven
- Spring Boot
- Spring Data
- H2 Database
- Lombok

### Requests

Foram criados os seguintes endpoints para o desafio:

```cmd
POST localhost:8080/api/pedido

{
    "pedido":"123456",
    "itens":[
        {
            "descricao": "Item A",
            "precoUnitario": 10,
            "qtd": 1
        },
        {
             "descricao": "Item B",
             "precoUnitario": 5,
             "qtd": 2
        }]
}
```

```cmd
GET localhost:8080/api/pedidos

[
    {
        "pedido": "123456",
        "itens": [
            {
                "descricao": "Item A",
                "precoUnitario": 10.00,
                "qtd": 1
            },
            {
                "descricao": "Item B",
                "precoUnitario": 5.00,
                "qtd": 2
            }
        ]
    },
    {
        "pedido": "1234567",
        "itens": [
            {
                "descricao": "Item A",
                "precoUnitario": 10.00,
                "qtd": 1
            },
            {
                "descricao": "Item B",
                "precoUnitario": 5.00,
                "qtd": 2
            }
        ]
    }
]
```

```cmd
GET  localhost:8080/api/pedido/{pedido}

{
    "pedido": "123456",
    "itens": [
        {
            "descricao": "Item A",
            "precoUnitario": 10.00,
            "qtd": 1
        },
        {
            "descricao": "Item B",
            "precoUnitario": 5.00,
            "qtd": 2
        }
    ]
}
```

```cmd
DELETE  localhost:8080/api/pedido/{pedido}
```

```cmd
POST  localhost:8080/api/status

{
    "status":"APROVADO",
    "itensAprovados": 3,
    "valorAprovado": 20,
    "pedido":"123456-N"
}

Response

{
    "pedido": "123456-N",
    "status": [
        "CODIGO_PEDIDO_INVALIDO"
    ]
}
```
