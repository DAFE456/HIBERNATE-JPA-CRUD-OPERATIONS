Converted JDBC to Hibernate JPA

I refactored the project to replace plain JDBC with Hibernate JPA for database operations.

Reason for the change:

Simpler database interactions: Hibernate automatically maps Java objects to database tables, reducing boilerplate code like manual ResultSet handling.

Improved maintainability: Entities and repositories make the code cleaner and easier to manage as the project grows.

Built-in features: JPA provides automatic transaction management, caching, and query abstraction, which are not available with raw JDBC.

Better integration with Spring Boot: Using JPA repositories allows full use of Spring Data features like findById(), pagination, and custom queries.

Impact:
The project now has a more robust, scalable, and maintainable data access layer while reducing potential bugs from manual SQL handling.
