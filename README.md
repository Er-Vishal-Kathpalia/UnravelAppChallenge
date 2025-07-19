# 🚀 Backend System Optimization Challenge
This project demonstrates a robust, high-performance Java backend system designed to solve real-world challenges such as:

- ✅ Task1: Thread-safe session management  
- ✅ Task2: Memory optimization with controlled caching  
- ✅ Task3: Concurrent task scheduling with prioritization  
- ✅ Task4: Deadlock detection and prevention  
- ✅ Task5: Optimized database connection pooling with HikariCP  

## 🛠 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Maven**
- **MySQL**
- **HikariCP** (Connection Pooling)
- **Guava Cache**
- **Lombok**
- **SLF4J / Logback**
- **JProfiler / VisualVM** (for monitoring)

## ✅ Key Components

### 🔐 Session Management
- Custom session store using `ConcurrentHashMap`
- Auto-cleanup with `ScheduledExecutorService`
- TTL support and thread safety ensured

### 🧠 Memory Optimization
- In-memory cache with eviction strategy
- Built using Guava's `CacheBuilder`
- Prevents memory leaks and stale object references

### ⚙️ Priority-Based Concurrency
- Tasks executed based on custom-defined priorities
- Built on `ThreadPoolExecutor` and `PriorityBlockingQueue`

### 🪝 Deadlock Prevention
- Uses `ReentrantLock` with timeout via `tryLock`
- Lock hierarchy enforced to prevent circular waits
- Logs potential deadlocks with thread identification

### 🧵 Database Connection Pooling
- Uses **HikariCP** for fast, lightweight connection management
- Configured for optimal idle/active connection ratio
- Connection timeout, max-lifetime, and leak detection enabled


## 🔧 Setup Instructions

### 🧰 Prerequisites

- Java 17 or higher
- Maven 3.8+
- MySQL running locally or via Docker

### 🚀 Run the Project

```bash
# Build
mvn clean install

# Run
mvn spring-boot:run


---

## 👨‍💻 Author

**Vishal Kathpalia**  
- 🔗 [LinkedIn](https://linkedin.com/in/yourprofile)  
- 📧 vishal.kathpalia@example.com

