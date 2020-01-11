# Car Dashboard Configuration

### REST API
All rest calls expects the userId in the headers.

* [GET] /token: returns token for authentication
* [GET] /rest/cars: fetch all cars for userId
* [GET] /rest/user: fetch user information
* [GET] /rest/configuration/{carId}: fetch all configurations for particular car and user
* [POST] /rest/configuration: saves configuration for car and user based on body information.

### Quick Guide
SpringBoot application with H2 database in-memory (not durable). The PoC has the following elements:

* Spring Security using token
* Database layer using Spring Data.
* It is possible to populate the database with "start-up" data, this info is inside data.sql file inside resources folder.
* Controller and Service layers implements basic functionalities.
* Unit tests still to be implemented.
