# TimeLink – Backend  
**Spring Boot API for Community Time Banking**

TimeLink backend provides a secure, modular and scalable API for the time-exchange platform. It manages authentication, users, services, time transactions, and service requests.

---

## System Overview

This API enables:

- User registration & authentication  
- Service creation and categorization  
- Time-based requests  
- Transaction logging  
- Review and rating system  
- Secure access through Spring Security  

The backend is built with **Java 21**, **Spring Boot**, and **PostgreSQL**.

---

## Architecture

**Backend Architecture (MVC + Layered Design)**  
- Controller layer  
- Service layer  
- Repository layer (Spring Data JPA)  
- DTO mapping  
- Custom exceptions  
- Security layer with AuthenticationProvider  
- Data validations via Jakarta Validation  

**High-Level Diagram**

```
Client → Controller → Service → Repository → Database  
          ↓DTO Mapper      ↓Entities
```

---

## Database Schema

This backend follows a TimeBanking domain model including:

- `users`  
- `roles`, `user_roles`  
- `services`, `categories`  
- `service_requests`  
- `time_transactions`  
- `reviews`

(Models correspond to the ER diagram provided during development.)

---

## Tech Stack & Versions

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 21 | Backend Programming |
| Spring Boot | 3.3+ | Application Framework |
| Spring Security | 6+ | Authentication / Authorization |
| Spring Data JPA | — | Persistence Layer |
| PostgreSQL | 16 | Database |
| Lombok | — | Boilerplate reduction |
| MapStruct | — | DTO mapping |
| Maven | — | Dependency Management |

---

## Security Features

The backend implements:

### ✔ Authentication  
- Email + password login  
- AuthenticationManager  
- Custom `UserDetailsService`  
- Password hashing with BCrypt  

### ✔ Authorization  
- Roles (`USER`, `ADMIN`)  
- Protected endpoints  
- CORS configured for frontend  

### ✔ Validation  
- Field-level validation (email, password, required fields)  
- Custom exceptions (e.g., EmailAlreadyExistsException)

### ✔ Error Handling  
- Global exception handler  
- Clear error responses for frontend integration  

---

## Tests

- Unit tests (JUnit 5 + Mockito)  
- Integration tests for Controllers & Repositories  
- Security tests for protected endpoints  

---

## Project Structure

```
src/main/java/com/timelink/
 ├── controller/
 ├── dto/
 ├── exceptions/
 ├── mapper/
 ├── model/
 ├── repository/
 ├── security/
 ├── service/
 │     └── impl/
 └── TimelinkApplication.java
```

---

## Getting Started

### 1. Clone repository
```bash
git clone https://github.com/YOUR-USERNAME/timelink-backend.git
cd timelink-backend
```

### 2. Configure database  
Create database:
```sql
CREATE DATABASE timelink;
```

Update `application.properties`:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/timelink
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
```

### 3. Run backend
```bash
mvn spring-boot:run
```

Backend will start at:  
```
http://localhost:8080
```

---

## About the Developer

**Erika P. Montoya**  
Multilingual (ES / EN / IT) Full-Stack Developer (React + Spring Boot)  
Passionate about building useful, human-centered software.  
Brings adaptability, clarity, multilingual communication, and commitment to continuous improvement.

**LinkedIn:** [LinkedIn](https://www.linkedin.com/in/erikamontoya/)  
**GitHub:** [GitHub](https://github.com/DevErika)

---

## License
This project was developed as part of the Factoría F5 Full-Stack Bootcamp.
