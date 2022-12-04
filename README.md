
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
