# backbase-example-project

A Backbase example project demonstrating how to build and run a Spring Boot microservice using the Backbase Service SDK. It consists of two modules:

- **`messaging-api`** — OpenAPI spec and generated Spring Boot interfaces for the messaging service
- **`example-service`** — Spring Boot service that implements the `messaging-api` spec

## Prerequisites

- Java 21
- Maven 3.x
- Docker & Docker Compose

## Quick Start

Build everything and start the full stack:

```bash
./start.sh
```

Once running:

| Service          | URL                        |
|------------------|----------------------------|
| Example Service  | http://localhost:8080      |
| Eureka Registry  | http://localhost:8761      |

To stop and clean up:

```bash
./stop.sh
```

## Project Structure

```
backbase-example-project/
├── messaging-api/          # OpenAPI spec + generated interfaces
├── example-service/        # Spring Boot service implementation
├── docker-compose.yaml     # Runs registry + example-service
├── start.sh                # Build and start all services
└── stop.sh                 # Stop and remove all containers
```

## Modules

### messaging-api

Defines the OpenAPI spec for the messaging service and generates Spring Boot interfaces via the [BOAT Maven plugin](https://backbase.io/developers/documentation/boat/). Must be installed locally before building `example-service`.

```bash
cd messaging-api && mvn install -DskipTests
```

### example-service

Spring Boot microservice that implements the `messaging-api` interfaces. Registers with Eureka and is secured via Backbase Internal JWT.

```bash
cd example-service && mvn spring-boot:run
```

See each module's `README.md` for more details.

## Authorization

Requests to `example-service` require a Backbase Internal JWT. For local development, generate a token at [jwt.io](https://jwt.io) using `JWTSecretKeyDontUseInProduction!` as the HMAC secret.

> **Note:** Never use the default secret key in production.
