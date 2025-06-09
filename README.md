# movie-tracker
Project Title:
Movie Tracker Web Application (Spring Boot Version)

Description:
Movie Tracker is a modern, full-stack web application built using Spring Boot, designed to help users efficiently manage their movie lists. It allows users to add, update, view, and delete movie entries, while automatically categorizing them as either "Want to Watch" or "Already Watched" based on the presence of Date Watched and Rating.
The application follows a clean, layered architecture with Controller, Service, and Repository layers, and uses Spring Data JPA to interact with a PostgreSQL database for seamless object-relational mapping and persistence.The frontend is developed using Thymeleaf, a server-side template engine that enables dynamic rendering of movie data. The UI is responsive and intuitive, featuring visually distinct sections for the two movie lists. Each movie record includes fields such as Title, Language, Genre, Release Year, optional Date Watched, and Rating (1–10).
Key Features and Technologies:
Spring MVC for request handling and RESTful routing
Spring Data JPA for simplified database operations
Thymeleaf for dynamic server-side HTML rendering
HikariCP for efficient database connection pooling
Validation annotations for form input and data integrity
Maven for build automation and dependency management
