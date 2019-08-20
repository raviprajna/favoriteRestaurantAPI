# Project Description

The project is based on a small web service which uses the following technologies:
* Java 1.8
* Spring Boot
* Database H2 (In-Memory)
* Maven

# Getting started
1. Go to root of the project ( where pom.xml is present ) execute
   mvn clean install
2. cd target
3. java -jar mytaxi_server_applicant_test-1.0.0-SNAPSHOT.jar
4. launch https://localhost:8080



# Conventions 

 * All new entities have an ID with type of Long and a date_created with type of ZonedDateTime.
 * The architecture of the web service is built with the following components:
 	* dto : Objects which are used for outside communication via the API
    * controller: Implements the processing logic of the web service, parsing of parameters and validation of in- and outputs.
    * service : Implements the business logic and handles the access to the DataAccessObjects.
    * dao : Interface for the database. Inserts, updates, deletes and reads objects from the database.
    * entity : Functional Objects which might be persisted in the database.
 * Code formatter for IntelliJ IDEA and Eclipse in the etc folder



