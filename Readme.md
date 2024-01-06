# Hexagonal Architecture Project

This project demonstrates the implementation of a Hexagonal Architecture for a modular and maintainable application. The Hexagonal Architecture, also known as Ports and Adapters or Onion Architecture, promotes the separation of concerns and allows for easy replacement or modification of components without affecting the overall system.

## Project Structure

The project is structured into various modules, each representing a different layer or aspect of the Hexagonal Architecture. The modules are categorized as follows:

### Core Modules

1. **user-service/application/common**: Common utilities and shared functionalities.
2. **user-service/application/domain**: Domain entities and business logic.
3. **user-service/application/port**: Ports or interfaces defining interactions with the outside world.

### Application Adapters

1. **user-service/application/adapter/in/web-adapter**: Web interface adapter for handling incoming HTTP requests.
2. **user-service/application/adapter/in/websocket-adapter**: Websocket adapter for handling incoming websocket connections.
3. **user-service/application/adapter/in/scheduler-adapter**: Scheduler adapter for handling scheduled tasks.
4. **user-service/application/adapter/in/inbound-kafka-adapter**: Kafka adapter for handling incoming messages from Kafka.

### External Adapters

1. **user-service/application/adapter/out/postgres-adapter**: Adapter for interacting with a PostgreSQL database.
2. **user-service/application/adapter/out/external-users-adapter**: Adapter for interacting with external user services.
3. **user-service/application/adapter/out/outbound-kafka-adapter**: Kafka adapter for sending messages to Kafka.

### Framework

1. **user-service/framework**: Framework-specific code and configurations.

## Dependency Management

Internal and external dependencies are managed using Maven. Internal dependencies include common, domain, and port modules, while external dependencies are declared for Spring Boot, Spring Cloud Stream, and MapStruct.

## Build Configuration

The project uses the Maven compiler plugin with specific configurations for annotation processors like Lombok and MapStruct. These processors enhance code generation and reduce boilerplate code.

## How to Build and Run

To build the project, run the following Maven command in the project root:

```bash
mvn clean install
