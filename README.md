<h1 align="center">
  <br>
  
  <br>
  login-register-jwt-mysql
  <br>
</h1>

<h4 align="center">login and registration service implementing JWT, and MySQL database</h4>


<p align="center">
    <a alt="Java">
        <img src="https://img.shields.io/static/v1?label=Java&message=v1.8&color=blue" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/static/v1?label=Spring%20Boot&message=2.3.1.RELEASE&color=brightgreen" />
    </a>
    <a alt="MySQL">
        <img src="https://img.shields.io/static/v1?label=MySQL&message=8.0.15&color=orange" />
    </a>
    <a alt="JWT">
        <img src="https://img.shields.io/static/v1?label=JWT&message=0.9.1&color=green" />
    </a>
</p>


## Concept ##
This is a Spring-boot authentication server application which authenticates a user and sends back a JSON Web Token. once authenticated these JSON Web tokens can be used by other applications to validate a user.

This application can be used as a template to create a standalone common authetication servers

features:
  1. This application utilizes Spring Security to block all incoming requests without proper authentication and authorization. 
  2. It uses jdbc authentication to validate/autheticate users from MySQL database and JPA - Java Persistence API.
  3. It sends a 'Json Web Token' with first request to authentication url '/authenticate'.
  2. additionaly, this application also applie a filter before every subsequent requests to validate the token if any in the request body.


