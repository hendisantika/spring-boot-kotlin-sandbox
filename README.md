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
- `GET /pokemon/{id}` - Get Pokemon by ID
- `GET /pokemon/range?start={start}&end={end}` - Get Pokemon in a range
- `GET /pokemon/x/{id}` - Get Pokemon by ID with enhanced error handling
- `GET /pokemon/name/{name}` - Get Pokemon by name

### Digimon Controller

- `GET /digimon/{name}` - Get Digimon by name

### Other Controllers

The project includes several other controllers demonstrating different features:

- User Controller
- Location Controller
- Extension Class Controller

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
