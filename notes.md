
---

### ✅ 1. Dependency Injection in Java (Spring)

There are two primary ways to inject dependencies:

---

#### 👉 Constructor Injection:

* Dependencies are provided through the class constructor.
* Promotes **immutability** — fields can be declared `final`.
* Ensures **mandatory dependencies** are initialized at object creation.
* **Safer**, as the compiler enforces dependency presence.
* Preferred for **required** dependencies.

```java
public class OrderService {
    private final PaymentProcessor processor;

    public OrderService(PaymentProcessor processor) {
        this.processor = processor;
    }
}
```

---

#### 👉 Setter Injection:

* Dependencies are injected via setter methods.
* Less verbose if you have many dependencies.
* Suitable for **optional** dependencies or where delayed injection is needed.
* ⚠️ **Risky**: If a setter is not called before using the dependent method, it may lead to a **NullPointerException**.

```java
public class OrderService {
    private PaymentProcessor processor;

    public void setPaymentProcessor(PaymentProcessor processor) {
        this.processor = processor;
    }
}
```

---

### ✅ 2. `@Autowired` Annotation

* Used to **enable automatic dependency injection**.
* If a class has **multiple constructors**, `@Autowired` helps Spring decide which constructor to use.
* Can be placed on:

    * Constructors
    * Setters
    * Fields (not recommended due to testability issues)

```java
@Service
public class PaymentService {
    // Business logic
}

@Service
public class OrderService {
    private final PaymentService paymentService;

    @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
```

> By using `@Service` on both `PaymentService` and `OrderService`, we're instructing Spring to **create beans** for both classes. Then, Spring uses `@Autowired` to **inject the `PaymentService` bean into `OrderService`** automatically.

---

### ✅ 3. `Spring vs Spring Boot`

| Feature                    | Spring (Classic)               | Spring Boot                                 |
| -------------------------- | ------------------------------ | ------------------------------------------- |
| 🔧 Configuration           | Manual (XML or Java-based)     | Auto-configured (sensible defaults)         |
| 🧱 Dependency Management   | Manual (define all versions)   | Uses Spring Boot Starter BOMs               |
| 🚀 Application Startup     | Needs external server (Tomcat) | Embedded server (Tomcat/Jetty)              |
| 🧪 Testing Setup           | Manual                         | Built-in support via `@SpringBootTest`      |
| 🌱 Project Structure       | Flexible, but verbose          | Opinionated but quick to bootstrap          |
| 🔌 Third-party integration | Manual boilerplate code        | Auto-configures things like JPA, Kafka      |
| 📦 Build & Run             | Needs WAR or external setup    | Runnable JAR with `spring-boot:run`         |
| 📊 Actuator (Monitoring)   | Manual setup                   | Built-in via `spring-boot-starter-actuator` |
