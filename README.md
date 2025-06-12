# Hibernate-Demo-Project
Student Management System (Hibernate + MySQL)
This project is a Java-based Student Management System that demonstrates how to manage student records using Hibernate ORM and MySQL. The application supports CRUD operations, pagination, and showcases best practices in Java backend development with JPA and Hibernate.

Features:
Student Management: Add, update, delete, and fetch student records. |
Certificate Association: Each student can have multiple certificates (one-to-many relationship). |
Hibernate ORM: Uses Hibernate for object-relational mapping, session management, and transaction handling. |
JPA Annotations: Defines entity relationships, constraints, and table mappings using JPA. |
MySQL Integration: Stores all data in a MySQL database, with unique constraints on student email and name. |
Pagination Support: Fetch students with pagination for efficient data handling. |
Flexible Queries: Demonstrates both Hibernate Query Language (HQL) and Criteria API for data retrieval. |
Robust Error Handling: Handles duplicate entries and database exceptions gracefully. |
Clean Project Structure: Organized into entities, services, utilities, and resources. 

Technologies Used:
Java,
Hibernate ORM,
JPA (Jakarta Persistence API),
MySQL,
Maven,
IntelliJ IDEA (or any Java IDE)

How It Works
Entities:
Student: Represents a student with fields like name, email, college, branch, year, phone number, about, and a list of certificates.
Certificates: Represents a certificate with fields like title, about, link, and a reference to the owning student.
|
Relationships:
One-to-Many: One student can have multiple certificates, managed using JPA's @OneToMany and @ManyToOne annotations with cascading and orphan removal.
Persistence:
When a student is saved, all associated certificates are automatically persisted to the database.
|
Database:
The schema is automatically generated/updated by Hibernate based on the entity definitions.

Getting Started:
1.)Clone the repository.
2.)Configure your MySQL database and update hibernate.cfg.xml with your credentials.
3.)Build and run the project using Maven or your IDE.
4.)Use the main class to add students and certificates, and verify data in MySQL
