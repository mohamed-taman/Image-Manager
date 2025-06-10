# Image Management Tool (**IMT**)
A full-stack image management web application built with Java (Spring Boot) on the backend and Angular on the frontend. 

The tool enables user registration, login, image uploads (including bulk via ZIP), manage, and search images with metadata, download individual or multiple images securely, conversion of SVG to PNG, and user profile management.

**Additionally**, you can use the image as an icon for **diagrams** or **architectural diagrams** in presentations or other diagramming applications like [diagrams.io](https://www.drawio.com/).

---

## 🚀 Core Functionalities

- 🔐 **User Management**: User registration, login, and JWT token-based authentication
- 🖼️ **Image Management**: 
  - Upload single images or ZIP files with multiple images.
  - View, update, delete, or download individual or bulk images.
- 🧾 Automatic conversion of SVG images to high-quality PNG format
- 🔍 **Image Search**: Filter images by metadata and keywords.
- 🧑‍💼 User profile management (update personal info)
- 📥 Download individual images or as ZIP
- 📜 Swagger UI for API documentation

---

## 🛠️ Technologies Used
### Backend

- **Java 22+** – [Download](https://jdk.java.net/22/) – Primary backend language
- **Spring Boot 3.4+** – [Docs](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) – Framework for building backend services
- **Maven** – [Download](https://maven.apache.org/download.cgi) – Build and dependency management tool
- **Spring Security & JWT** – For authentication and token management
- **H2 Database** – [Docs](https://www.h2database.com/html/main.html) – In-memory DB for fast dev/testing
- **Flyway** – [Docs](https://flywaydb.org/documentation/) – Database version control
- **Apache Batik** – [Download](https://xmlgraphics.apache.org/batik/) – SVG to PNG conversion
- **Lombok** – [Docs](https://projectlombok.org/) – Boilerplate reduction for Java classes
- **JUnit 5 + Mockito** – Unit and integration testing

### Frontend

- **Angular 17+** – [Download](https://angular.io/) – Frontend framework
- **Angular CLI** – [Docs](https://angular.io/cli) – Development tooling
- **Bootstrap** – UI styling

### DevOps

- **Docker** – [Download](https://www.docker.com/products/docker-desktop/) – Containerization
- **Swagger/OpenAPI** – [Docs](https://swagger.io/tools/swagger-ui/) – REST API docs
- **GitHub Actions** – CI/CD automation (optional)

---

## 📁 Project Structure
### Backend (`/backend`)
```
com.taman.imagetool
├── config # JWT, security, Swagger config
├── controller # REST endpoints
├── dto # Data Transfer Objects
├── domain # Entity classes
├── repository # Spring Data JPA interfaces
├── service # Business logic
├── util # SVG converter and utility helpers
├── exception # Custom exceptions and handlers
├── ImageToolApp # Main Spring Boot application class
```

### Frontend (`/frontend`)
```
src/app
├── auth # Login, Register, Forgot Password
├── image # Upload, Search, List, Download
├── profile # User profile management
├── core # Interceptors, services, auth guards
├── shared # Reusable components and models
```

---

## ⚙️ Build and Run
### Backend

```bash
# Navigate to the backend root folder
cd backend

# Clean and package
mvn clean install

# Run the Spring Boot application
java -jar target/imagetool-0.0.1-SNAPSHOT.jar
```
Swagger UI: http://localhost:8090/swagger-ui/index.html

### Frontend
```bash
# Navigate to Angular frontend folder
cd frontend

# Install dependencies
npm install

# Run the app
ng serve --open
```
Default URL: http://localhost:4200

---

## 🐳 Docker Support
### Build Docker Image
```bash
# Navigate to the backend root folder
cd backend

# Clean and package
mvn clean install

# In project root (where Dockerfile exists)
docker build -t imagetool .
```
### Run with Docker Compose
```bash
docker-compose up --build
```

---

## 📄 Environment Configuration
- Includes JWT secret, DB config, etc to `application.yaml`. 
- Set `SPRING_PROFILES_ACTIVE=prod` for production profile.

---
## Test
### 🧪 Run Tests
```bash
# Unit and integration tests
mvn test
```

### 🧪 API Test Collection
Use Swagger UI or import Postman collection from `docs/postman_collection.json`.

---

## ✅ Project Status

1. [ ] 🔄 Backend complete
2. [ ] 🔄 Angular frontend integrated
3. [ ] 🔄 Dockerized deployment
4. [ ] 🔄 Future: Role-based access control, external DB support

## 👤 Authors & Contributions
Maintained by the Mohamed Taman. Contributions welcome!
### 📬 Contact & Contribution
To contribute or raise issues, please submit a pull request or open an issue in the GitHub repository.

---
## 📃 License
This project is licensed under the MIT License.