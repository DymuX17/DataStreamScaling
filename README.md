# DataStreamScaling  
### A Full Real-Time Event Streaming Platform with Spring Boot, Kafka, Docker, Prometheus, Grafana, and Cloud-Native Architecture  

DataStreamScaling is a multi-module, cloud-native microservices system designed to demonstrate a fully functional real-time streaming pipeline using **Apache Kafka**, **Spring Boot**, **Docker**, and a complete observability stack.  
The project is structured to resemble real-world, production-grade distributed systems and is ideal for demonstrating cloud engineering, backend engineering, DevOps, event-driven design, and scalability in cloud environments. 

It is planned to add horizontal scalability using **Kubernetes**.

Its goal is to provide a complete, educational, and professional MVP that mirrors how modern tech companies build data streaming and event-driven systems.

---

# 🌐 System Architecture

```
+---------------------+       +------------+       +----------------------+       +----------------------+
|   Producer Service  | --->  |   Kafka    | --->  |   Consumer Service   | --->  |   (future) Database  |
|   Spring Boot       |       |   Broker   |       |   Spring Boot        |       |   Postgres/CH        |
+---------------------+       +------------+       +----------------------+       +----------------------+


 +-----------------------------------------------------------------------+        +----------------------+
 |                   Observability & Monitoring Stack                    |        |   Containerization   |
 |                    Prometheus • Grafana • Kafka UI                    |        |   using Docker       |
 +-----------------------------------------------------------------------+        +----------------------+
```

---

# 🚀 Project Goals

- Build a **cloud-ready**, horizontally scalable pipeline.
- Demonstrate end-to-end streaming: **producer → Kafka → consumer**.
- Provide **clean modular structure** for future extensions (Kafka Streams, DB, K8s).
- Showcase **infrastructure engineering skills**: Docker, monitoring, metrics.
- Act as a **real portfolio project** for backend/cloud engineering roles.

---

# 📦 Modules Overview

## 1. **Producer**
- Spring Boot service generating synthetic `Order` events every second.
- Publishes JSON messages to Kafka topic `orders`.
- Idempotent, fault-tolerant Kafka producer configuration.
- Includes metrics endpoint (`/actuator/prometheus`).

## 2. **Consumer**
- Subscribes to Kafka topic `orders`.
- Deserializes JSON → Order model.
- Processes incoming messages in real-time.
- Includes configurable consumer group and offset reset.
- Includes full logging of consumed events.

## 3. **Processor** *(coming soon)*
- Planned Kafka Streams microservice.
- Performs transformations, filtering, aggregations, windowing.
- Will output transactions to new topics for further processing.

## 4. **Monitoring** *(coming soon)*
- **Kafka UI** for observing brokers, topics, lags, partitions.
- **Prometheus** scrapes metrics from Producer and Consumer.
- **Grafana** visualizes real-time dashboards:
  - Kafka consumer lag
  - Processing throughput
  - JVM metrics
  - Application-level metrics
 
## 5. **Kubernetes Scalability** *(coming soon)*

- The platform will be deployed onto a Kubernetes cluster 
- The horizontal scalability will be implemented.
- Deployments for **Producer**, **Consumer**, and **Processor**
- Services for cluster-internal communication
- Horizontal Pod Autoscaler (HPA) based on:
    - CPU usage
    - Kafka consumer lag metrics
    - processing throughput

---

# 🛠️ Technology Stack

| Category | Technology |
|---------|------------|
| Language | **Java 21** |
| Framework | **Spring Boot 3.5** |
| Messaging | **Apache Kafka 3.7.0** |
| Build Tool | **Maven (multi-module)** |
| Containerization | **Docker**, Docker Compose |
| Future Observability | **Prometheus**, **Grafana** |
| Future Storage | Postgres / Snowflake |
| Future Cloud Runtime | Kubernetes (EKS / K3s) |

---

# 🧩 Detailed Architecture Description

## 🔹 Real-time message generation  
The Producer microservice simulates a real e‑commerce flow by generating random orders:

- unique `orderId`
- dynamic `userId`
- randomized `amount`

All messages are published to a Kafka topic using a robust KafkaTemplate configuration.

## 🔹 Event consumption
The Consumer service:

- listens to the same topic (`orders`)
- deserializes messages into `Order` objects
- logs processed messages
- ensures at‑least‑once delivery semantics
- isolates processing using its own consumer group


## 🔹 Production-like environment
Docker Compose orchestrates:

- Kafka broker
- Producer
- Consumer
- Kafka UI
- Prometheus
- Grafana

---

# 🧪 How to Run Locally

### 1. Clone repo
```
git clone <your-repo-url>
cd DataStreamScaling
```

### 2. Build project
```
mvn clean package -DskipTests
```

### 3. Start entire environment
```
docker compose up -d --build
```

---

# 📌 Module Status

| Module | Status |
|--------|--------|
| Producer | ✅ Completed |
| Consumer | 🟡 Active development |
| Processor | 🔜 Planned |
| Postgres Integration | 🔜 Planned |
| Kubernetes Deployment | 🔜 Planned |

---

# 🧭 Roadmap

### Phase 1 – Core System (DONE)
✔ Event generator  
✔ Kafka setup  
✔ Producer → Kafka → Consumer  
✔ Multi-module architecture  
✔ Full Dockerized setup  
