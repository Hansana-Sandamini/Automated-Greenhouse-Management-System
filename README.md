# 🚀  Automated Greenhouse Management System (AGMS)

A Spring Boot-based Microservices project designed for monitoring and automation using Sensor, Zone, Crop, and Automation services with API Gateway, Feign Client communication, and Circuit Breaker for fault tolerance.

---

# 🧩 Architecture Overview

This system follows a microservices architecture:

- 🌐 API Gateway (Request Routing)
- 📡 Sensor Service (Manages sensor data)
- 🗺️ Zone Service (Manages zones/locations)
- 🌱 Crop Service (Manages crop data)
- ⚙️ Automation Service (Applies business rules)

---

# 🔌 Service Ports

| Service              | Port  |
|---------------------|------|
| API Gateway         | 8080 |
| Sensor Service      | 8081 |
| Zone Service        | 8082 |
| Crop Service        | 8083 |
| Automation Service  | 8084 |
| Eureka Server (opt) | 8761 |

---

# 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Cloud Gateway
- OpenFeign
- Resilience4j
- MySQL
- Maven

---

# 📦 Microservices

## 📡 Sensor Service (Port: 8081)
- CRUD operations for sensors
- Communicates with Zone Service using Feign Client
- Uses Circuit Breaker for fault tolerance

## 🗺️ Zone Service (Port: 8082)
- Manages zone/location data
- Provides data to other services

## 🌱 Crop Service (Port: 8083)
- Handles crop-related data
- Independent microservice

## ⚙️ Automation Service (Port: 8084)
- Applies rules on sensor data
- Generates alerts (e.g., high temperature)

## 🌐 API Gateway (Port: 8080)
- Routes all incoming requests
- Single entry point for system

---

# 🔗 Communication Flow

Client → API Gateway → Services  
Sensor Service ↔ Zone Service (Feign)  
Automation Service → Sensor Service

---

# ⚡ Features

✔ Microservices architecture  
✔ API Gateway routing  
✔ Feign Client communication  
✔ Circuit Breaker (Resilience4j)  
✔ DTO-based responses  
✔ Global exception handling

---

# 🔥 Fault Tolerance

Circuit Breaker ensures:
- No system crash if a service fails
- Fallback responses are returned

---

# 📌 API Endpoints

## Sensor Service
POST   /api/sensors  
GET    /api/sensors  
GET    /api/sensors/{id}

## Zone Service
POST   /api/zones  
GET    /api/zones  
GET    /api/zones/{id}

## Crop Service
POST   /api/crops  
GET    /api/crops  
GET    /api/crops/{id}

## Automation Service
POST   /api/automation

---

# 🚀 How to Run

1. Start Eureka Server (optional) → http://localhost:8761
2. Start API Gateway → http://localhost:8080
3. Start Zone Service → http://localhost:8082
4. Start Sensor Service → http://localhost:8081
5. Start Crop Service → http://localhost:8083
6. Start Automation Service → http://localhost:8084

---

# 🧪 Testing Flow

1. Create Zone
2. Create Sensor
3. Fetch Sensor (with Zone data)
4. Send request to Automation Service

---

# 🎯 Learning Outcome

- Microservices communication
- Fault tolerance design
- Clean architecture
- Real-world backend system

---

# ⚙️ Clone the repository
```
git clone https://github.com/Hansana-Sandamini/Automated-Greenhouse-Management-System.git
cd AGMS
```

