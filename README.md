# Team 6

## Table of Contents

### Documents

* Team Agreement
* Team Introduction
* Team Logo

### Product Backlog

Contains folders containing each version of the following:

* Personas
* User Stories

### Sprint Backlog

Contains folders containing each version of the following:

* Sprint Plan
* Provisional Burndown Chart
* Sprint Execution
* Execution Burndown Chart
* Task Breakdown (From Sprint 3 onwards)

As well as a breakdown of the tasks from the kanban board for each deliverable
Task breakdowns before Sprint 3 are contained in the Deliverable 3 Task Breakdown file.

### Code Review

Contains code review documentation for each of the following:

* Deliverable 4

### Demonstration Video

You can find the link to the demonstration video here
[https://drive.google.com/file/d/16BlK3z_aXLJYJJWubMW8FtGxIGjoHuWv/view?usp=sharing](https://drive.google.com/file/d/16BlK3z_aXLJYJJWubMW8FtGxIGjoHuWv/view?usp=sharing)

### Development Environment

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Maven 3.2+](https://maven.apache.org/download.cgi)
* [MySQL 5.6](https://dev.mysql.com/downloads/mysql/5.6.html)

```sh
cp src/main/resources/application-local.properties src/main/resources/application.properties
mvn spring-boot:run
```

### Docker

```
cp src/main/resources/application-docker.properties src/main/resources/application.properties
docker-compose up
```

### Production 

```sh
mvn package && java -jar target/team6-0.1.0.jar
```
