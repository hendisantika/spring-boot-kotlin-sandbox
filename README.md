# Spring Boot Kotlin Sandbox

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

- Kotlin 1.9.25
- Spring Boot 3.5.3
- Java 21
- Gradle
- Kotlin Coroutines
- OkHttp & Ktor HTTP clients
- Jackson & Kotlinx Serialization
- Spring Kafka
- Lombok

## Prerequisites

- JDK 21
- Gradle
- Kafka (optional, for messaging features)

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

## Contributing

Feel free to fork this project and add your own experiments or improvements.

## Author

Hendi Santika

- Email: hendisantika@yahoo.co.id
- Telegram: @hendisantika34
- Website: s.id/hendisantika
