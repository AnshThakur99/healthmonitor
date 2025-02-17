healthmonitor

This project is a simplified backend system for monitoring patient heart rate data. Built using Spring Boot, it provides RESTful APIs to manage users, patients, and heart rate records.

Features
- User Management: Registration and login with basic email and password validation.
- Patient Management: Add patients and retrieve patient details.
- Heart Rate Data: Record and retrieve heart rate data for patients.
- Robust Error Handling: Basic error handling and data validation.
- In-Memory Database: Uses H2 for quick setup and testing.

Assumptions and Design Decisions
- Database: An H2 in-memory database is used for simplicity; it can be replaced with MySQL or PostgreSQL for production.
- Authentication: Basic email and password matching is used for login without implementing advanced security protocols.
- Data Relationships: Users, Patients, and HeartRateRecords are related simply; you can expand these relationships based on further requirements.
- Error Handling: Basic global exception handling is in place; more detailed logging and handling can be added as needed.
- Testing: Unit tests are optional and not included in this implementation.
- Technology Stack: Spring Boot, Spring Data JPA, H2 Database, and Lombok (to reduce boilerplate code).

 API Documentation

User Endpoints
- Register User
  - URL:`POST /api/users/register`
  - Body:
    json
    {
      "email": "example@example.com",
      "password": "password123"
    }
    
  - Response: Returns the registered user object.

- Login User
  - URL: `POST /api/users/login`
  - Body:
    json
    {
      "email": "example@example.com",
      "password": "password123"
    }
    
  - Response: Returns a success message if login is successful, or a 401 error if not.

 Patient Endpoints
- Add Patient
  - URL: `POST /api/patients/add`
  - Body:
    json
    {
      "name": "John Doe",
      "address": "123 Main St",
      "phone": "1234567890"
    }
  - Response: Returns the saved patient object.

Get Patient Details
  - URL: `GET /api/patients/{id}`
  - Response: Returns the patient object for the specified ID.

### Heart Rate Endpoints
- Record Heart Rate
  - URL: `POST /api/heartrate/record/{patientId}?heartRate=80`
  - Response:Returns the recorded heart rate record.
  
- Retrieve Heart Rate Records
  - URL:`GET /api/heartrate/patient/{patientId}`
  - Response:Returns a list of heart rate records for the specified patient.

## Testing
Use tools like Postman or cURL to test the endpoints. Make sure your application is running at `http://localhost:8080` before sending requests.

## Further Enhancements
- Implement advanced user authentication (e.g., JWT).
- Add comprehensive unit and integration tests.
- Integrate with a frontend application for better user experience.
- Replace H2 with a persistent database like MySQL or PostgreSQL.
- Enhance error handling and logging mechanisms.
