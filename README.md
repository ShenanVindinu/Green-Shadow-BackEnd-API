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

### Authentication  
| Method | Endpoint            | Description           |  
|--------|---------------------|-----------------------|  
| POST   | `/api/auth/login`   | Authenticate user and return JWT. |  
| POST   | `/api/auth/signup`  | Register a new user.  |  

### User Management  
| Method | Endpoint            | Description           |  
|--------|---------------------|-----------------------|  
| GET    | `/api/users`        | Retrieve all users.   |  
| POST   | `/api/users/update` | Update user details.  |  

### Resource Management (Examples)  
| Resource   | Endpoint                 | Methods |  
|------------|--------------------------|---------|  
| Crops      | `/api/crops`             | GET, POST, PUT, DELETE |  
| Fields     | `/api/fields`            | GET, POST, PUT, DELETE |  
| Equipment  | `/api/equipment`         | GET, POST, PUT, DELETE |  
| Vehicles   | `/api/vehicles`          | GET, POST, PUT, DELETE |  
| Logs       | `/api/logs`              | GET, POST, PUT, DELETE |  

## File Structure  
```plaintext  
greenShadow-backend/  
├── src/  
│   ├── main/  
│   │   ├── java/  
│   │   │   └── com/greenshadow/ # Main application package  
│   │   ├── resources/  
│   │   │   ├── application.properties # Configuration  
│   │   │   └── data.sql # Sample data  
├── pom.xml         # Maven build file  
├── README.md       # Project documentation  
└── LICENSE         # License file  
```  

## Security  
This project uses Spring Security for authentication and authorization. JWT tokens are issued upon successful login and are required for accessing protected resources.  

### Roles and Permissions  
- **ADMIN**: Full access to all endpoints.  
- **MANAGER**: Restricted access to certain CRUD operations.  
- **SCIENTIST/OTHER**: Limited read/write permissions.  

## Contributing  
Contributions are welcome! Fork the repository, make your changes, and submit a pull request.  

## License  
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.  

---
