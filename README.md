```markdown
# 🚀 Smart Shuttle Management System

A **real-time campus shuttle management system** built with **Spring Boot**, **Angular**, **PostgreSQL**, and **AWS**. It provides **live tracking, seat reservations, and ETA calculations** using the **Haversine Algorithm**, ensuring efficient transportation for students and staff.

## 🛠 Tech Stack
- **Backend**: Java **Spring Boot**, **PostgreSQL**, **REST API**
- **Frontend**: **Angular**, TypeScript
- **Cloud Services**: **AWS (EC2, S3, RDS)**
- **Authentication**: **JWT**
- **Geospatial ETA Calculation**: **Haversine Algorithm**
- **Real-Time Tracking**: **Google Maps API / AWS Location**

---

## 🚀 How to Run (Spring Boot + Angular)

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/vedantsp/Smart-Shuttle-Management-System.git
cd Smart-Shuttle-Management-System
```

### 2️⃣ Run the Backend (Spring Boot)
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
- **API will be available at**: `http://localhost:8080`

### 3️⃣ Run the Frontend (Angular)
```bash
cd frontend
npm install
ng serve
```
- **App will be available at**: `http://localhost:4200`

---

## 📌 Configure PostgreSQL (`application.properties`)
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/shuttle_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```

---

## ✅ Ready to Go!
- Login, **book a seat**, and **track shuttles live** 🚍  
- Drivers can **update locations**, and **admins** manage **routes & schedules**.  

📌 **Check API Documentation:** `http://localhost:8080/swagger-ui.html`  

🔗 **GitHub Repository:** [Smart Shuttle Management System](https://github.com/vedantsp/Smart-Shuttle-Management-System)
```
