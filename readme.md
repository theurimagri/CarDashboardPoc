# Car Dashboard Configuration

## REST API
All rest calls expects the userId and authorization token in the headers.

* [GET] /token: returns token for authentication by userId (hardcoded)
* [GET] /rest/user: fetches user information based on userId
* [GET] /rest/users/info: fetches user information for all users
* [POST] /rest/configuration: creates configuration for car and user based on body information.
* [PUT] /rest/configuration: updates configuration for car and user based on body information.
* [GET] /rest/configuration/{carId}: fetches configuration for user and car.
* [DEL] /rest/configuration/{configurationId}: deletes a configuration by id.

### OpenApi UI (Swagger-UI)

You can access the OpenApi(SwaggerUI) dash-board via: **http://localhost:<APP_PORT>/swagger-ui.html**

## Quick Guide
SpringBoot application with H2 database in-memory (not durable). The PoC has the following elements:

* Spring Security using token
* Database layer using Spring Data.
* It is possible to populate the database with "start-up" data, this info is inside data.sql file inside resources folder.
* Controller and Service layers implements basic functionalities.
* It would be nice to plug Swagger to expose the API methods
* Unit tests still to be implemented.
