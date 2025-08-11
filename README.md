# Enterprise Resource Management (ERM) API

A backend application built with **Java + Spring Boot** for managing users, products, orders, and audit logs.

---

## 📌 Tech Stack
- **Java 17** (or higher)
- **Spring Boot** (Web, Data JPA, Validation)
- **PostgreSQL** (Database)
- **Flyway** (Database migrations)
- **Lombok** (Boilerplate reduction)
- **BCrypt** (Password hashing)
- **Maven** (Build tool)

---

## 🚀 Features
- **User Management** — Create, read, update, delete users.
- **Product Management** — Manage product inventory.
- **Order Management** — Track customer orders.
- **Audit Logging** — Record system actions.
- **Validation** — Input data validation using `jakarta.validation`.

---

## 📂 Project Structure
```
src/main/java/com/example/erm
│
├── controller       # REST controllers  
├── dto              # Request/Response DTOs  
├── entity           # JPA entities  
├── repository       # Spring Data JPA repositories  
├── service          # Service interfaces  
├── service/impl     # Service implementations  
└── config           # App configuration (CORS, Security, etc.)  
```

---

## ⚙️ Setup & Run

### 1️⃣ Clone Repository
```bash
git clone https://github.com/your-username/erm-api.git
cd erm-api
```

### 2️⃣ Configure Database
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/erm_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
```

### 3️⃣ Run Migrations
Tables will be created automatically by **Flyway** on app startup.

### 4️⃣ Build & Run App
```bash
mvn spring-boot:run
```

App runs at:
```
http://localhost:8080
```

---

## 🧪 Test in Postman

### Create User
```bash
POST http://localhost:8080/api/users
Content-Type: application/json
```

**Request Body:**
```json
{
  "username": "johndoe",
  "email": "john@example.com",
  "password": "password123",
  "fullName": "John Doe",
  "role": "ADMIN"
}
```

**Expected Response:**
```json
{
  "id": 1,
  "username": "johndoe",
  "email": "john@example.com",
  "fullName": "John Doe",
  "role": "ADMIN"
}
```

---

## 📅 Next Steps
- Add **GET**, **PUT**, **DELETE** endpoints for Users.
- Implement **Product** & **Order** modules.
- Add **JWT authentication**.
- Integrate **Audit Logging**.
