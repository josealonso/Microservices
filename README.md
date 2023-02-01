### MONOLITH

- All components are part of a single unit.
- Everything is developed, deployed and scaled as one unit.
- The application must be written in one tech stack.
- Teams need to be careful to not affect each other's work.

**DISADVANTAGES**

- Parts/components are tightly coupled.
- High infraestructure costs, since only the entire application can be scaled.
- It is difficult to use different **dependency versions**.
- **Release process takes longer**.

### MICROSERVICES

The application is broken down into multiple smaller independent applications.
Each component/application is
- Loosely coupled.
- Developed independently.
- Deployed independently.
- Scaled independently.

#### Communicate microservices

**1.- SYNCHRONOUS Communication**

The protocol HTTP/HTTPS is synchronous and the client code can only continue 
its task when an HTTP server response is received.
Examples: RestTemplate, WebClient and Spring Cloud Open Feign library.

**2.- ASYNCHRONOUS Communication**

The client sends a request and does not wait for a response.
A message broker is used between the two microservices.
Examples: RabbitMQ or Apache Kafka.

### Architecture with Spring Cloud

API Gateway ----> handle the client request to the appropriate microservice.

Config Server --> externalize the configuration of the multiple microservices.

Service Registry and Registry Discovery ---->
keeps a list with the running instances of the microservices 

Distributed Tracing ---->

Circuit Breaker


**Spring Cloud** provides models for implementing these patterns.

- Spring Cloud Netflix Eureka Server for Service Registry.
- Spring Cloud Config Server for Config Server.
- Spring Cloud Gateway for API Gateway.
- Resilience4j for Circuit Breaker.
- Spring Cloud Sleuth for distributed tracing.
- Zipkin provides a UI for Spring Cloud Sleuth.


### SERVICES

- Product Service

Dependencises: Lombok, Spring Web, Spring Data MongoDB.

- Order Service

- Inventory Service

- Notification Service

- Order Service, Inventory Service and Notification Service are going to interact with each other.

- Synchronous and asynchronous communication.

- Asynchronous communication betwenn the Order Service and the Notification Service through message queues (Kafka, RabbitMQ).

- A diagram will be drawn with the following blocks:

  - The mentioned services.

  - API Gateway.

  - Eureka Server.

  - Authorization Server (KeyClock).

  - Centralized logging.

  - Vault for storing the secrets.

  - Elasticsearch, logstash and Kibana (ELK).

### STEPS

- Install the Spring initializer command line

```
sudo ln -s /usr/lib/jvm/java-17-openjdk-amd64/ /usr/lib/jvm/default-java

sdk install springboot
```

`spring --version`

> Spring CLI v3.0.0
