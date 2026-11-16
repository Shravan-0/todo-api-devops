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
# Jenkins automatic CI test

## CI/CD Automation

This project uses GitHub Actions and Jenkins to automate testing and application builds.

### GitHub Actions

The GitHub Actions workflow is located at `.github/workflows/ci.yml`.

The workflow runs when code is pushed to the `main` branch or when a pull request targets `main`.

Pipeline stages:

1. Checkout source code.
2. Set up Java 17 using Temurin.
3. Run unit tests using `mvn -B test`.
4. Build the application using `mvn -B package -DskipTests`.
5. Upload the generated JAR as the `todo-api-jar` artifact.

### Jenkins Pipeline

The `Jenkinsfile` defines the Jenkins automation pipeline.

Pipeline stages:

1. Environment Check – verifies Java and Maven versions.
2. Checkout – retrieves the source code.
3. Automated Tests – executes Maven tests.
4. Build Application – packages the application.

Jenkins also publishes JUnit test reports and archives the generated JAR after a successful build.

The pipeline checks the source repository using SCM polling every minute.
