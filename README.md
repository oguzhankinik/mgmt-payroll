This project includes API transactions, validation, exception handling, and testing.

Used H2 DB in this project.

This application is dockerized using the docker file.

**Teck Stack:**

Java 8 

Spring Boot project

Maven to manage centralized libraries

Open API UI has been used to REST API documentation. URI:http://localhost:8080/swagger-ui/index.html

Spring Actuator is used to check the application health URI:http://localhost:8080/actuator/health

H2 in-memory DB has been used to store data. DB UI URI:http://localhost:8080/h2-console?URL=jdbc:h2:mem:testdb

Lombok is being used to avoid boilerplate codes

Spring Data JPA has been used to do DB operations

Spring Boot Devtools has been used to do faster development 

JUnit has been used to test operations

Spring Boot Validation has been used to make Controller validation 

Apache Commons Lang3 has been used to make Service validation 

Model Mapper has been used for mapping object  

Slf4j has been used to logging mechanism

Yaml file has been created to read properties