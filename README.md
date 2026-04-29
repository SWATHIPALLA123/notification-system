# 🚀 Notification System API
 
## 📌 Overview
This is a Spring Boot backend project that manages:
- Users
- Notification Preferences (EMAIL, SMS, PUSH)
- Notification Sending
- Notification History
 
---
 
## ⚙️ Tech Stack
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
 
---
 
## 📁 Project Structure
src/main/java/com/notification/
controller
service
repository
entity
dto
enums
exception
 
---
 
## 👤 User APIs
 
POST /users  
Create user
 
GET /users/{id}  
Get user by ID
 
GET /users  
Get all users
 
---
 
## 🔔 Preference APIs
 
PUT /preferences/{userId}  
Create or update preference
 
GET /preferences/{userId}  
Get preferences by user
 
---
 
## 📩 Notification APIs
 
POST /notifications  
Send notification
 
---
 
## 📊 Notification History APIs
 
GET /notifications/user/{userId}  
GET /notifications/status/{status}  
GET /notifications/type/{type}
 
---
 
## 📌 Business Rules
- Disabled channels should not receive notifications
- Each notification attempt is stored
- Default: all channels disabled
 
---
 
## ▶️ How to Run
 
1. Clone repo  
git clone https://github.com/SWATHIPALLA123/notification-system  
 
2. Open in IDE  
 
3. Run NotificationSystemApplication.java  
 
---
 
## 🗄️ H2 Database
 
http://localhost:8080/h2-console  
 
JDBC URL: jdbc:h2:mem:testdb  
 
---
 
## 👩‍💻 Author
Swathi Palla
GitHub - SWATHIPALLA123/notification-system: Spring Boot Notification System with User Preferences and Delivery API
Spring Boot Notification System with User Preferences and Delivery API   - SWATHIPALLA123/notification-system
 
