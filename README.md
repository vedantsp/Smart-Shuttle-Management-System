Thought for a couple of seconds


````markdown
# Smart Shuttle Management System

A real-time campus shuttle management solution built with Spring Boot, Angular, PostgreSQL, and AWS. Features live tracking, seat reservations, and ETA calculations (Haversine Algorithm) to ensure efficient transportation for students and staff.

---

## Motivation

Manually managing campus shuttle services often leads to delays, miscommunication, and underutilization. This system automates:

- Real‑time GPS tracking  
- Optimized route planning  
- Seat reservations  
- ETA calculations  

to improve user experience and shuttle efficiency.

---

## Features

- **Live Tracking**: Drivers update their location; users see shuttles moving on a map.  
- **Seat Reservations**: Students and staff can book seats in advance.  
- **ETA Calculation**: Uses the Haversine Algorithm for accurate arrival estimates.  
- **Role-Based Access**:  
  - **Users**: Book seats and track shuttles.  
  - **Drivers**: Update location in real time.  
  - **Admins**: Manage routes, schedules, and users.

---

## Tech Stack

| Layer                     | Technologies                                 |
|---------------------------|----------------------------------------------|
| **Backend**               | Java, Spring Boot, REST API, JWT auth        |
| **Frontend**              | Angular, Google Maps API                     |
| **Database**              | PostgreSQL                                   |
| **Geospatial Processing** | Haversine Algorithm                          |
| **Cloud Deployment**      | AWS EC2, S3, RDS                             |

---

## Getting Started

1. **Clone the repository**  
   ```bash
   git clone https://github.com/vedantsp/Smart-Shuttle-Management-System.git
   cd Smart-Shuttle-Management-System
````

2. **Backend (Spring Boot)**

   ```bash
   cd backend
   mvn clean install
   mvn spring-boot:run
   ```

   The API will be available at `http://localhost:8080`.

3. **Frontend (Angular)**

   ```bash
   cd ../frontend
   npm install
   ng serve
   ```

   The app will run at `http://localhost:4200`.

---

## Repository

[Smart Shuttle Management System](https://github.com/vedantsp/Smart-Shuttle-Management-System)

```
```
