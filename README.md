# TimeLink Backend

This repository contains the backend of *TimeLink*, a time-banking web application where users can exchange services using time credits instead of money. The backend is built with Spring Boot 3 and follows a clean, modular architecture suitable for production-ready applications and academic evaluation.

## Technologies
- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Security (JWT coming soon)
- PostgreSQL
- Maven
- Lombok


## Project Structure
 ```
src/main/java/com/timelink/timelink
 ├── controller        # REST controllers
 ├── service           # Business logic interfaces
 │    └── impl         # Service implementations
 ├── repository        # JPA repositories
 ├── model             # Entities and enums
 ├── dto               # Request and response DTOs
 ├── mapper            # Mappers (MapStruct planned)
 ├── security          # Security and JWT configuration (upcoming)
 └── exceptions        # Custom exceptions
 ```
## Current Features
- `User` entity with:
  - Required fields: id, name, email, password
  - Optional fields: address, postalCode, bio
  - Role support (`USER`, `ADMIN`)
  - BCrypt password encryption
  - Default credit balance
  - Validation annotations for required fields
- `UserRepository` with custom queries (`findByEmail`, `existsByEmail`)
- `UserService` and `UserServiceImpl` with:
  - Registration logic
  - Duplicate email validation
  - Password hashing
  - User lookup by id or email

## In Progress
- `UserController`
- Custom exception handling
- Authentication and authorization with JWT
- CRUD for services offered and requested
- Time credit calculation system
- Integration with the React frontend

## How to Run
1. Clone the repository:
   git clone https://github.com/DevErika/timelink-backend.git

2. Configure PostgreSQL connection in `src/main/resources/application.properties`.

3. Start the server:
   mvn spring-boot:run

## Related Repository
Frontend of the TimeLink application:
https://github.com/DevErika/timelink-frontend

## Status
This README is a first draft and will be expanded as development continues.
