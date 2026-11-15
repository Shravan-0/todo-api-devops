# Todo API - DevOps Assignment

A simple REST API developed using Java 17 and Spring Boot.

## Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | / | Application information |
| GET | /todos | List all tasks |
| GET | /todos/{id} | Get a task |
| POST | /todos | Create a task |
| GET | /actuator/health | Application health |

## Technology Stack

- Java 17
- Spring Boot
- Maven
- Git and GitHub
- Jenkins
- Ansible
- Docker
- Kubernetes

## Build

mvn clean package

## Run

java -jar target/todo-api.jar
