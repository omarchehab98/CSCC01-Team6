# Team "Ok Hand"
![Team 06](https://github.com/CSCC01/Team6/blob/master/Documents/TeamLogo.png "Team 06")
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
