# Spring Boot Kotlin Sandbox

[![Java CI with Gradle](https://github.com/hendisantika/spring-boot-kotlin-sandbox/actions/workflows/gradle.yml/badge.svg)](https://github.com/hendisantika/spring-boot-kotlin-sandbox/actions/workflows/gradle.yml)

A sandbox project demonstrating various Kotlin features and integrations with Spring Boot.

## Description

This project serves as a playground for experimenting with Kotlin features in a Spring Boot environment. It includes
examples of:

- Kotlin Coroutines for asynchronous programming
- HTTP clients (OkHttp and Ktor)
- JSON serialization/deserialization
- Integration with external APIs (Pokemon API, Digimon API)
- Kafka messaging
- Result pattern for error handling
- And more!

## Technologies Used

- Kotlin 2.4.21
- Spring Boot 4.1.1
- Java 25
- Gradle 9.8.2 (via the wrapper)
- Kotlin Coroutines
- OkHttp & Ktor 3 HTTP clients
- Jackson & Kotlinx Serialization
- Spring Kafka
- Lombok

## Prerequisites

- JDK 25
- Kafka (optional, for messaging features; defaults to `localhost:9092`)

No local Gradle install is needed: use the bundled `./gradlew` wrapper.

## Getting Started

1. Clone the repository
2. Build the project: `./gradlew build`
3. Run the application: `./gradlew bootRun`

The application will start on port 8080 by default.

## API Endpoints

### Home Controller

- `GET /` - Simple coroutine example
  ```bash
  curl http://localhost:8080/
  ```

- `GET /pokemon/{id}` - Get Pokemon by ID
  ```bash
  curl http://localhost:8080/pokemon/1
  ```

- `GET /pokemon/range?start={start}&end={end}` - Get Pokemon in a range
  ```bash
  curl "http://localhost:8080/pokemon/range?start=1&end=5"
  ```

- `GET /pokemon/x/{id}` - Get Pokemon by ID with enhanced error handling
  ```bash
  curl http://localhost:8080/pokemon/x/25
  ```

- `GET /pokemon/name/{name}` - Get Pokemon by name
  ```bash
  curl http://localhost:8080/pokemon/name/pikachu
  ```

### Digimon Controller

- `GET /digimon/{name}` - Get Digimon by name
  ```bash
  curl http://localhost:8080/digimon/agumon
  ```

### Other Controllers

The project includes several other controllers demonstrating different features:

- User Controller
  ```bash
  # Get list of users
  curl http://localhost:8080/users

  # Get user count
  curl http://localhost:8080/users/count
  ```

- Location Controller
  ```bash
  # Get location by ID
  curl http://localhost:8080/locations/1
  ```

- Extension Class Controller
  ```bash
  # Get user by ID with capitalized first name
  curl http://localhost:8080/extension_class/user/1
  ```

## Features Demonstrated

- **Coroutines**: Asynchronous programming with structured concurrency
- **HTTP Clients**: Making API calls with OkHttp and Ktor
- **JSON Processing**: Using both Jackson and Kotlinx Serialization
- **Error Handling**: Using sealed classes for the Result pattern
- **Kafka Integration**: Publishing messages to Kafka topics
- **Extension Functions**: Kotlin's ability to extend existing classes

## CI & Dependency Updates

- **GitHub Actions** (`.github/workflows/gradle.yml`) builds and tests every push and pull request to `main` on
  Temurin JDK 25, and submits the dependency graph for Dependabot alerts.
- **Dependabot** (`.github/dependabot.yml`) checks Gradle and GitHub Actions dependencies daily at 05:00 (Asia/Jakarta).
  Related libraries are grouped into a single PR (Kotlin, kotlinx, Ktor, Spring, GitHub Actions) so that
  versions that must match, such as the Kotlin Gradle plugins, are always bumped together.

## Contributing

Feel free to fork this project and add your own experiments or improvements.

## Author

Hendi Santika

- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
- Website: s.id/hendisantika
