# Todo List Application

This is a simple Todo List application built with Spring Boot, JPA, and H2 Database.

## Features

- Create, read, update, and delete (CRUD) todo items.
- In-memory H2 database for easy setup and testing.
- RESTful API endpoints for managing todo items.

## Technologies Used

- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/carloseduardo/todolist.git
    cd todolist
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### Configuration

The application uses an in-memory H2 database by default. You can find the configuration in the `src/main/resources/application.properties` file.

```ini
spring.application.name=todolist

spring.datasource.url=jdbc:h2:mem:todolist
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

### API Endpoints

The application exposes the following RESTful API endpoints:

- `GET /todos` - Retrieve all todo items
- `GET /todos/{id}` - Retrieve a specific todo item by ID
- `POST /todos` - Create a new todo item
- `PUT /todos/{id}` - Update an existing todo item by ID
- `DELETE /todos/{id}` - Delete a specific todo item by ID

### Entity

The `Todo` entity is defined as follows:

```java
@Entity
@Getter @Setter
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    private boolean realizado;

    private int prioridade;
}
```

### Repository

The `TodoRepository` interface extends `JpaRepository` to provide CRUD operations for the `Todo` entity.

```java
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
```
