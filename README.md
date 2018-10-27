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

### Development Environment

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Maven 3.2+](https://maven.apache.org/download.cgi)
* [MySQL 5.6](https://dev.mysql.com/downloads/mysql/5.6.html)

#### Development

```sh
mvn compile && mvn exec:java -Dexec.mainClass="team6.Application"
# or, run using docker (optional)
docker-compose up 
```

Navigate to http://localhost:8080 in your browser

#### Production 

```sh
mvn package && java -jar target/team6-0.1.0.jar
```
