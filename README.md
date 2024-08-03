# Secure Pass

This application is a group of two services, one for generating secure passwords, one for checking the strength of a password, and another for storing them.

It's my implementation of the Password Generator and Password Checker challenges from the [Back-end Challenges](https://github.com/wesleybertipaglia/backend-challenges/) repository.

The application is built with Java, Spring Boot, PostgreSQL, and Docker.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Running](#running)
- [Entities](#entities)
- [Contributing](#contributing)
- [License](#license)

## Features

The application includes the following functionalities:

- Password Generator
- Password Checker
- Password Storage
- User Authentication and Authorization
- Pagination, sorting, and filtering
- Entity Validation
- Exception Handling
- API documentation (Swagger)
- Automated tests
- Logging
- Production, Development, and Test profiles
- Docker support (Dockerfile, docker-compose)
- CI/CD pipeline

## Getting Started

### Running with Docker

The easiest way to run the application is with Docker.

**1. Prerequisites**

- **Docker**, you can download and install it from [here](https://www.docker.com/products/docker-desktop).
- **Docker Compose**, you can download and install it from [here](https://docs.docker.com/compose/install/).

**2. Create the .env file**

- Create a `.env` file in the root directory following the .env.example file.
- Edit the `.env` file and set the environment variables.

**3. Running**

To run the application, execute the following command:

```bash
docker-compose up
```

> The application will be available at `http://localhost:8080`.

> The API documentation is available at `http://localhost:8080/swagger-ui.html`.

## Entities

The following Entity-Relationship Diagram (ERD) shows the properties of the Demo entity:

```mermaid
classDiagram
    class User {
        + Long id
        + String username
        + String password
        + String role
        + LocalDateTime createdAt
        + LocalDateTime updatedAt
    }

    class Password {
        + Long id
        + String value
        + String strength
        + LocalDateTime createdAt
        + LocalDateTime updatedAt
        + User user
    }

    User "1" -- "0..*" Password : owns
```

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.