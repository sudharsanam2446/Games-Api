# Getting Started
* API First Design using OpenAPI Contracts Code Gen.
* Other tech stacks used are SpringBoot, OpenAPI, Gradle, Mockito

### Prerequisites
* gradle-6.9.2
* Java 8

### How to run the project

* Run the cmd "gradle clean build". It will generate the APIs and the swagger documentations based on the contract defined in "src/main/resources/openapi.yml"
* Hit http://localhost:8080/games/swagger-ui/index.html to access the swagger page and play with it.
* H2 DB can be accessed using, http://localhost:8080/games/h2-console/
  * url: jdbc:h2:mem:mydb
  * username: sa
  * password: password
  * driverClassName: org.h2.Driver
  

### Improvements

* Improved error handling
* Implement Retries with Exponential backoff for Recoverable Exceptions 
* Improve Unit test coverage
* Split openapi.yml contract
* Retries with Exponential BackOff
* Implement Redis Cache
* Add Integration Tests 
* Consider the proposed microservices architeture - Coming Soon!


