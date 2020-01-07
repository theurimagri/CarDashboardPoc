# Car Dashboard Configuration

### REST API
All rest calls expects the userId in the headers.

* [GET] /cars: fetch all cars
* [GET] /users: fetch all users
* [GET] /configurations: fetch all configurations
* [GET] /configuration/{carId}: fetch all configurations for particular car and user
* [POST] /configuration: saves configuration for car and user based on body information.

### Quick Guide
SpringBoot application with H2 database in-memory (not durable). The PoC has the following elements:

* Database layer using Spring Data.
* It is possible to populate the database with "start-up" data, this info is inside data.sql file inside resources folder.
* Controller and Service layers implements basic funcionalities.
* Unit tests still to be implemented.
