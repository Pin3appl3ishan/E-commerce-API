# Spring Store - E-Commerce REST API

A comprehensive e-commerce REST API built with Spring Boot, featuring user authentication, product management, shopping cart functionality, payment processing with Stripe, and order management.

## 🚀 Features

### Authentication & Authorization

- JWT-based authentication with access and refresh tokens
- Secure login/logout functionality
- Token refresh mechanism
- Role-based access control

### Product Management

- CRUD operations for products and categories
- Product filtering by category
- Product search and listing

### Shopping Cart

- Create and manage shopping carts
- Add/remove items from cart
- Update item quantities
- Clear cart functionality

### Payment Processing

- Stripe integration for secure payments
- Webhook handling for payment events
- Checkout session management

### Order Management

- Order creation and tracking
- Order history for users
- Order status management

### User Management

- User registration and profile management
- User addresses and preferences
- Wishlist functionality

## 🛠 Technology Stack

### Backend Framework

- **Spring Boot 3.4.1** - Main application framework
- **Java 17** - Programming language
- **Maven** - Dependency management

### Database & Persistence

- **MySQL** - Primary database
- **Spring Data JPA** - Data access layer
- **Flyway** - Database migration tool

### Security

- **Spring Security** - Authentication and authorization
- **JWT (JSON Web Tokens)** - Stateless authentication
- **BCrypt** - Password hashing

### Payment Processing

- **Stripe Java SDK** - Payment gateway integration

### Additional Tools

- **MapStruct** - Object mapping
- **Lombok** - Code generation
- **SpringDoc OpenAPI** - API documentation
- **Thymeleaf** - Template engine (for admin views)
- **Spring Validation** - Input validation

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Stripe account (for payment processing)

## ⚙️ Setup and Installation

### 1. Clone the Repository

```bash
git clone <repository-url>
cd spring-store
```

### 2. Database Setup

```sql
-- Create the database (will be created automatically if using the default config)
CREATE DATABASE store_api;
```

### 3. Environment Configuration

Create a `.env` file in the root directory or set environment variables:

```env
# Database Configuration
DB_USERNAME=root
DB_PASSWORD=your_mysql_password

# JWT Configuration
JWT_SECRET=your_jwt_secret_key
JWT_ACCESS_TOKEN_EXPIRATION=900000
JWT_REFRESH_TOKEN_EXPIRATION=604800000

# Stripe Configuration
STRIPE_SECRET_KEY=your_stripe_secret_key
STRIPE_WEBHOOK_SECRET=your_stripe_webhook_secret

# Application Configuration
WEBSITE_URL=http://localhost:8080
```

### 4. Run Database Migrations

```bash
mvn flyway:migrate
```

### 5. Build and Run the Application

```bash
# Build the application
mvn clean package

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📚 API Documentation

### Authentication Endpoints

#### Login

```http
POST /auth/login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "password123"
}
```

#### Refresh Token

```http
POST /auth/refresh
Cookie: refreshToken=your_refresh_token
```

#### Get Current User

```http
GET /auth/me
Authorization: Bearer your_access_token
```

### Product Endpoints

#### Get All Products

```http
GET /products
# Optional: Filter by category
GET /products?categoryId=1
```

#### Create Product (Admin)

```http
POST /products
Authorization: Bearer your_access_token
Content-Type: application/json

{
  "name": "Product Name",
  "description": "Product description",
  "price": 29.99,
  "categoryId": 1
}
```

#### Update Product (Admin)

```http
PUT /products/{id}
Authorization: Bearer your_access_token
Content-Type: application/json

{
  "name": "Updated Product Name",
  "description": "Updated description",
  "price": 34.99,
  "categoryId": 1
}
```

#### Delete Product (Admin)

```http
DELETE /products/{id}
Authorization: Bearer your_access_token
```

### Cart Endpoints

#### Create Cart

```http
POST /carts
```

#### Get Cart

```http
GET /carts/{cartId}
```

#### Add Item to Cart

```http
POST /carts/{cartId}/items
Content-Type: application/json

{
  "productId": 1
}
```

#### Update Cart Item

```http
PUT /carts/{cartId}/items/{productId}
Content-Type: application/json

{
  "quantity": 3
}
```

#### Remove Item from Cart

```http
DELETE /carts/{cartId}/items/{productId}
```

#### Clear Cart

```http
DELETE /carts/{cartId}/items
```

### Checkout & Payment Endpoints

#### Create Checkout Session

```http
POST /checkout
Authorization: Bearer your_access_token
Content-Type: application/json

{
  "cartId": "cart-uuid",
  "customerEmail": "customer@example.com"
}
```

#### Stripe Webhook

```http
POST /checkout/webhook
Stripe-Signature: webhook_signature
Content-Type: application/json

{
  "webhook_payload": "..."
}
```

### Order Endpoints

#### Get All Orders (User's orders)

```http
GET /orders
Authorization: Bearer your_access_token
```

#### Get Specific Order

```http
GET /orders/{orderId}
Authorization: Bearer your_access_token
```

## 🗄️ Database Schema

### Main Tables

- **users** - User accounts and credentials
- **profiles** - Extended user information
- **addresses** - User shipping addresses
- **categories** - Product categories
- **products** - Product catalog
- **carts** - Shopping carts
- **cart_items** - Cart line items
- **orders** - Order records
- **order_items** - Order line items
- **wishlist** - User wishlists

## 🔧 Configuration

### Application Properties

Key configuration in `src/main/resources/application.yaml`:

```yaml
spring:
  application:
    name: spring-store
  datasource:
    url: jdbc:mysql://localhost:3306/store_api?createDatabaseIfNotExist=true
    username: ${DB_USERNAME:root}
    password: ${DB_PASSWORD:Password}
  jpa:
    show-sql: true
  jwt:
    secret: ${JWT_SECRET:default_secret}
    accessTokenExpiration: 900000
    refreshTokenExpiration: 604800000

stripe:
  secretKey: ${STRIPE_SECRET_KEY}
  webhookSecretKey: ${STRIPE_WEBHOOK_SECRET}
```

## 🧪 Testing

### Run Tests

```bash
mvn test
```

### API Testing

You can use tools like Postman, curl, or any HTTP client to test the API endpoints. The application also includes Swagger UI for interactive API documentation.

Access Swagger UI at: `http://localhost:8080/swagger-ui.html`

## 📦 Build and Deployment

### Create JAR

```bash
mvn clean package
```

### Run JAR

```bash
java -jar target/store-0.0.1-SNAPSHOT.jar
```

### Docker Support

The application can be containerized using Docker. Create a `Dockerfile` in the project root:

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/store-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contribution

Feel free to clone the repo and extend it. You can also create PRs if you wish to contribute in this repo. However, I won't be extending this project further myself.

---
