# run-the-bank-challenge

## Utilização do endpoint

- Para situação da transferência, utilizei o endpoint passado no desafio, e caso o serviço esteja fora do ar, a operação é revertida

## Payloads

### Cadastro de clientes

POST /customer/insert
```json
{
    "name": "Rafael",
    "address": "Avenida Interlagos",
    "document": "12345678900",
    "password": "F1rst",
    "customerType": "F"
}
```

### Consultar cliente por ID

GET /customer/show?id={{idCustomer}}

Response:
```json
{
    "name": "Rafael",
    "address": "Avenida Interlagos",
    "password": "F1rst",
    "customerType": "F",
    "document": "12345678900"
}
```

### Cadastro de contas

POST /account/insert
```json
{
    "agency": "123",
    "balance": 100,
    "active": true,
    "idCustomer": 1
}
```
### Transferência entre contas

PATCH /transaction/transfer
```json
{
    "amount": 50,
    "idAccountPayer": 1,
    "idAccountPayee": 2
}
```

## Sugestões de melhoria da arquitetura

-   Utilização de um banco de dados que não seja em tempo de execução
-   Relacionamento do banco de dados, pois facilitaria algumas operações
