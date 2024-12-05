# GreenShadow API 🌿  

GreenShadow API is a backend system for managing crops, fields, equipment, vehicles, staff, and logs. Built with Spring Boot, it features robust security using Spring Security and supports JWT authentication for secure access to resources.  

## Features  
- **Authentication and Authorization**:  
  - Secure login/signup with JWT tokens.  
  - Role-based access control (ADMIN, MANAGER, SCIENTIST, OTHER).  

- **Resource Management**:  
  - CRUD operations for crops, fields, equipment, vehicles, staff, and logs.  

- **Scalable Architecture**:  
  - Built using RESTful principles.  
  - Modular and extensible.  

- **Spring Boot Features**:  
  - Built-in dependency injection.  
  - Integrated Spring Security for authentication and authorization.  

## Technologies Used  
- **Framework**: Spring Boot (Java)  
- **Security**: Spring Security with JWT  
- **Database**: MySQL/PostgreSQL (configurable)  
- **Build Tool**: Maven  

## Setup and Installation  

### Prerequisites  
1. Java 21 or later.  
2. Maven installed.  
3. MySQL database running.  

### Steps to Run the Project  
1. Clone the repository:  
   ```bash  
   git clone https://github.com/ShenanVindinu/Green-Shadow-BackEnd-API.git  
   cd greenShadow-backend  
   ```  

2. Update database configuration in `application-dev.properties`:  
   ```properties  
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/greenShadowV1?createDatabaseIfNotExist=true
    spring.datasource.username=your user name
    spring.datasource.password=your mysql password  

    spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true
   ```  

3. Build and run the project:  
   ```bash  
   mvn clean install  
   mvn spring-boot:run  
   ```  

4. Access the API at:  
   - Base URL: `http://localhost:5050/api/v1`

## API Endpoints  

Here's the updated API structure with `v1` added to every endpoint:  

### Authentication  
| Method | Endpoint               | Description                          |  
|--------|-------------------------|--------------------------------------|  
| POST   | `/api/v1/auth/signing`  | Authenticate user and return JWT.    |  
| POST   | `/api/v1/auth/signup`   | Register a new user.                 |  

### User Management  
| Method | Endpoint                   | Description                          |  
|--------|----------------------------|--------------------------------------|  
| GET    | `/api/v1/user/getAllUsers` | Retrieve all users.                  |  
| POST   | `/api/v1/user/userUpdate`  | Update user details.                 |  

### Resource Management (Examples)  
| Resource   | Endpoint                    | Methods                |  
|------------|-----------------------------|------------------------|  
| Crops      | `/api/v1/crop`              | GET, POST, PUT, DELETE |  
| Fields     | `/api/v1/field`             | GET, POST, PUT, DELETE |  
| Equipment  | `/api/v1/equipment`         | GET, POST, PUT, DELETE |  
| Vehicles   | `/api/v1/vehicle`           | GET, POST, PUT, DELETE |  
| Logs       | `/api/v1/Mlog`              | GET, POST, PUT, DELETE |  

## File Structure  
```plaintext  
greenShadow-backend/  
├── src/  
│   ├── main/  
│   │   ├── java/  
│   │   │   └── com/greenshadow/  # Main application package
│   │   │       ├── config/       # Configuration classes
│   │   │       ├── controller/   # REST Controllers
│   │   │       ├── dao/          # Data Access Objects (Repositories)
│   │   │       ├── dto/          # Data Transfer Objects
│   │   │       ├── entity/       # Entities (JPA/Hibernate models)
│   │   │       ├── exception/    # Exception handling
│   │   │       ├── secure/       # Security configurations
│   │   │       ├── service/      # Service layer
│   │   │       └── util/         # Utility classes
│   │   ├── resources/  
│   │   │   └── application.properties # Configuration  
├── pom.xml         # Maven build file  
├── README.md       # Project documentation  
└── LICENSE         # License file
 
```  

## Security  
This project uses Spring Security for authentication and authorization. JWT tokens are issued upon successful login and are required for accessing protected resources.  

### Roles and Permissions  
- **MANAGER**: Full access to all endpoints.  
- **ADMIN**: Restricted access to certain CRUD operations.  
- **SCIENTIST/OTHER**: Limited read/write permissions.
- When Signup, User Role will be set to **OTHER** by default (only admin Manager can assign you a role)  

## Contributing  
Contributions are welcome! Fork the repository, make your changes, and submit a pull request.  

## License  
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.  

---
