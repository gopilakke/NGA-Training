WorkNest - Spring MVC + Hibernate + JSP Starter Project

This is a ready-to-import Maven WAR project. Steps to run:

1. Create a MySQL database named 'worknest' and update JDBC credentials in
   src/main/webapp/WEB-INF/spring-dispatcher-servlet.xml (dataSource bean).

2. Build the WAR:
   mvn clean package

3. Deploy the generated worknest.war (target/) to Tomcat 9/10 and start Tomcat.

4. Visit http://localhost:8080/<context>/register to create an account, then login.

Notes:
- Passwords are stored in plain text for demo purposes. Add BCrypt or Spring Security for production.
- You can switch to PostgreSQL by changing driver and dialect in spring-dispatcher-servlet.xml and pom.xml.
