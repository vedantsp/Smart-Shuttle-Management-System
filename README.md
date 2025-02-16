```markdown
### Smart Shuttle Management System
A real-time campus shuttle management system built with Spring Boot, Angular, PostgreSQL, and AWS. It provides live tracking, seat reservations, and ETA calculations using the Haversine Algorithm, ensuring efficient transportation for students and staff.

### Motivation
Managing campus shuttle services manually can lead to inefficiencies, delays, and miscommunication. This project aims to provide a seamless and automated solution for shuttle tracking, scheduling, and seat reservations. By integrating real-time GPS tracking and optimized route planning, the system enhances the user experience while improving shuttle utilization.

### Why This Tech?
- Java Spring Boot: Provides a scalable and efficient backend with built-in security and REST API support.
- Angular: Enables a responsive and dynamic frontend for an intuitive user experience.
- PostgreSQL: Ensures reliable and structured data storage for shuttle schedules, bookings, and user information.
- REST API: Facilitates seamless communication between the frontend and backend, making the system highly modular and extensible.
- AWS (EC2, S3, RDS): Provides cloud scalability, reliability, and cost-effective hosting for deployment.

### Tech Stack
- Backend: Java Spring Boot, PostgreSQL, REST API
- Authentication: JWT
- Geospatial ETA Calculation: Haversine Algorithm
- Real-Time Tracking: Google Maps API

How to Run (Spring Boot + Angular)

### Clone the Repository
```bash
git clone https://github.com/vedantsp/Smart-Shuttle-Management-System.git
cd Smart-Shuttle-Management-System
```

### Run the Backend (Spring Boot)
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
API will be available at: `http://localhost:8080`


## Ready to Go
Login, book a seat, and track shuttles live.  
Drivers can update locations, and admins manage routes and schedules.  
  

GitHub Repository: [Smart Shuttle Management System](https://github.com/vedantsp/Smart-Shuttle-Management-System)
```
