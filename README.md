## DOCUMENTATION API OPERATION LOG

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgresql-blue.svg?style=for-the-badge&logo=postgresql&logoColor=white)

Developed with the **Clean Architecture standard**, an application clearly 
separated from business concerns, application rules and infrastructure details, 
resulting in a highly modular, testable and easy to maintain system.

This project is an API built using **Java, Java Spring and Postgres**

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Database](#database)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)


## Installation

1. Clone the repository:

```bash
git clone https://github.com/setxpro/cashback-customer-wallet.git
```

2. Install dependencies with Maven

```bash 
    mvn clean install
```

## Configuration


## DATABASE

The project utilizes Postgres as the database.

## Usage

1. Start the application with Maven.
2. The API will be accessible at http://localhost:8080

## API Endpoints

### Create Customer

| Function            | Method | Endpoint |
|---------------------|--------|----------|
| **Create customer** | POST   | `/customer`   |

### Example

Request: - POST
```json
{
  "fullname" : "Cicrano Arara",
  "email" : "cicrano@gmail.com",
  "avatar" : "https://github.com/setxpro.png",
  "username" : "cicrano.arara",
  "password" : "181245"
}
```
Response:
```json
{
  "id": 4,
  "fullname": "Cicrano Arara",
  "email": "cicrano@gmail.com",
  "avatar": "https://github.com/setxpro.png",
  "wallet": {
    "id": 4,
    "balance": 0
  },
  "username": "cicrano.arara",
  "password": "181245"
}
```
---

### Get customers

| Function    | Method | Endpoint |
|-------------|--------|----------|
| **Get All** | GET    | `/customer`   |

### Example

Request: - GET

Response:
```json
[
  {
    "id": 1,
    "fullname": "Patrick Anjos da Rocha",
    "email": "patrickpqdt87289@gmail.com",
    "avatar": "https://github.com/setxpro.png",
    "wallet": null,
    "username": "patrick.anjos",
    "password": "181245"
  }
]
```
---

### Get one customer

| Function    | Method | Endpoint         |
|-------------|--------|------------------|
| **Get One** | GET    | `/customer/{id}` |

### Example

Request: - GET
````url
    /customer/1
````

Response:
```json
{
  "id": 1,
  "fullname": "Patrick Anjos da Rocha",
  "email": "patrickpqdt87289@gmail.com",
  "avatar": "https://github.com/setxpro.png",
  "wallet": {
    "id": 1,
    "balance": 200
  },
  "username": "patrick.anjos",
  "password": "181245"
}
```

---

### Transactions

### Create a new transaction

| Function               | Method | Endpoint            |
|------------------------|--------|---------------------|
| **Create transaction** | POST   | `/transaction` |

### Example

Request: - POST

````json
{
    "payer" :  2,
    "payee" : 3,
    "amount" : 200.00,
    "type" : "CREDIT_ACCOUNT"
}
````

Response:
```json
{
  "id": null,
  "payer": 2,
  "payee": 3,
  "amount": 200,
  "type": "CREDIT_ACCOUNT",
  "createdAt": "2024-04-22T15:37:32.4499862"
}
```
---

### Find one transaction by id

| Function                 | Method | Endpoint            |
|--------------------------|--------|---------------------|
| **Find one transaction** | GET    | `/transaction/{id}` |

### Example

Request: - GET
````url
    /transaction/6
````

Response:
```json
{
  "id": 6,
  "payer": 2,
  "payee": 3,
  "amount": 200,
  "type": "CREDIT_ACCOUNT",
  "createdAt": "2024-04-22T15:37:32.449986"
}
```
---

### Find one transaction by payerId

| Function          | Method | Endpoint                  |
|-------------------|--------|---------------------------|
| **Find by payer** | GET    | `/transaction/payer/{payerId}` |

### Example

Request: - GET
````url
    /transaction/payer/1
````

Response:
```json
[
  {
    "id": 2,
    "payer": 1,
    "payee": 2,
    "amount": 2000,
    "type": "CREDIT_ACCOUNT",
    "createdAt": "2024-04-22T14:40:49.221752"
  },
  {
    "id": 3,
    "payer": 1,
    "payee": 2,
    "amount": 2000,
    "type": "CREDIT_ACCOUNT",
    "createdAt": "2024-04-22T14:52:07.36227"
  },
  {
    "id": 4,
    "payer": 1,
    "payee": 2,
    "amount": 200,
    "type": "CREDIT_ACCOUNT",
    "createdAt": "2024-04-22T15:04:41.148629"
  }
]
```
---

### Find one transaction by payeeId

| Function               | Method | Endpoint                  |
|------------------------|--------|---------------------------|
| **Find by payee** | GET    | `/transaction/payee/{payeeId}` |

### Example

Request: - GET
````url
    /transaction/payee/3
````

Response:
```json
[
  {
    "id": 6,
    "payer": 2,
    "payee": 3,
    "amount": 200,
    "type": "CREDIT_ACCOUNT",
    "createdAt": "2024-04-22T15:37:32.449986"
  }
]
```
---

### Find all transactions by customerId

| Function                   | Method | Endpoint                  |
|----------------------------|--------|---------------------------|
| **Find all by customerid** | GET    | `/transaction/customer/{customerId}` |

### Example

Request: - GET
````url
    /transaction/customer/2
````

Response:
```json
[
  {
    "id": 2,
    "payer": 1,
    "payee": 2,
    "amount": 2000,
    "type": "CREDIT_ACCOUNT",
    "createdAt": "2024-04-22T14:40:49.221752"
  },
  {
    "id": 3,
    "payer": 1,
    "payee": 2,
    "amount": 2000,
    "type": "CREDIT_ACCOUNT",
    "createdAt": "2024-04-22T14:52:07.36227"
  },
  {
    "id": 4,
    "payer": 1,
    "payee": 2,
    "amount": 200,
    "type": "CREDIT_ACCOUNT",
    "createdAt": "2024-04-22T15:04:41.148629"
  },
  {
    "id": 5,
    "payer": 2,
    "payee": 1,
    "amount": 200,
    "type": "CREDIT_ACCOUNT",
    "createdAt": "2024-04-22T15:31:50.654305"
  },
  {
    "id": 6,
    "payer": 2,
    "payee": 3,
    "amount": 200,
    "type": "CREDIT_ACCOUNT",
    "createdAt": "2024-04-22T15:37:32.449986"
  }
]
```
---

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), and submit your changes in a separate branch.