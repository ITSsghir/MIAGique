# Jeux MIAGiques back-end

This is the back-end of the Jeux MIAGiques project. It is a REST API that allows the front-end to interact with the database.

## Setup

1. Setup a MySQL database (you can use the [`docker-compose.yml`](db/docker-compose.yml) file to start a MySQL server in a Docker container).

    > You can modify the `MYSQL_ROOT_PASSWORD` and `MYSQL_DATABASE` environment variables in the `docker-compose.yml` file to change the root password and the name of the database.
    >
    > You may also need to create the database manually, as the Docker container may not create it automatically.
    >
    > You can use the following command to create the database:
    >
    > ```bash
    > docker exec -it db
    > mysql -u root -p # Enter the root password when prompted
    > CREATE DATABASE jeuxmiagiques;
    > ```
    >
    > You can also use a MySQL client to connect to the database and create the database manually.

1. Run the Spring Boot application.

## API

The API is accessible at `http://localhost:8080/`

### Endpoints

#### Authentication

- `POST /login`: Log in a user. Creates a new session and returns a session id.
- `POST /register`: Register a new user. Creates a new user (spectator or organizer).

#### Spectators

- `GET /api/spectateurs`: Get all the spectators.
- `GET /api/spectateurs/{id}`: Get a spectator by its ID.
- `POST /api/spectateurs`: Create a new spectator.
- `PUT /api/spectateurs/{id}`: Update a spectator.
- `DELETE /api/spectateurs/{id}`: Delete a spectator.

#### Organizers

- `GET /api/organisateurs`: Get all the organizers.
- `GET /api/organisateurs/{id}`: Get an organizer by its ID.
- `POST /api/organisateurs`: Create a new organizer.
- `PUT /api/organisateurs/{id}`: Update an organizer.
- `DELETE /api/organisateurs/{id}`: Delete an organizer.

#### Events

- `GET /api/epreuves`: Get all the events.
- `GET /api/epreuves/{id}`: Get an event by its ID.
- `POST /api/epreuves`: Create a new event.
- `PUT /api/epreuves/{id}`: Update an event.
- `DELETE /api/epreuves/{id}`: Delete an event.

#### Participants

- `GET /api/participants`: Get all the participants.
- `GET /api/participants/{id}`: Get a participant by its ID.
- `POST /api/participants`: Create a new participant.
- `PUT /api/participants/{id}`: Update a participant.
- `DELETE /api/participants/{id}`: Delete a participant.

#### Tickets

- `GET /api/billets`: Get all the tickets.
- `GET /api/billets/{id}`: Get a ticket by its ID.
- `POST /api/billets`: Create a new ticket.
- `PUT /api/billets/{id}`: Update a ticket.
- `DELETE /api/billets/{id}`: Delete a ticket.

#### Sportive infrastructure

- `GET /api/infrastructuresportives`: Get all the sportive infrastructures.
- `GET /api/infrastructuresportives/{id}`: Get a sportive infrastructure by its ID.
- `POST /api/infrastructuresportives`: Create a new sportive infrastructure.
- `PUT /api/infrastructuresportives/{id}`: Update a sportive infrastructure.
- `DELETE /api/infrastructuresportives/{id}`: Delete a sportive infrastructure.

#### Delegations

- `GET /api/delegations`: Get all the delegations.
- `GET /api/delegations/{id}`: Get a delegation by its ID.
- `POST /api/delegations`: Create a new delegation.
- `PUT /api/delegations/{id}`: Update a delegation.
- `DELETE /api/delegations/{id}`: Delete a delegation.

### Data

The data is stored in a MySQL database. Check the [setup](#setup) section to see how to setup the database.

### Models

#### User

- `id`: The ID of the user.
- `prenom`: The first name of the user.
- `nom`: The last name of the user.
- `email`: The email of the user.
- `password`: The password of the user.
- `userRole`: The role of the user (spectator or organizer or participant).

#### Spectator

Polymorphic child of `User`, with no additional fields.

#### Organizer

Polymorphic child of `User`, with 1 additional field:

- `role`: The role of the organizer (organizer or controller).

#### Participant

Polymorphic child of `User`, with 1 additional field:

- `delegation`: The delegation that the participant represents.

#### Event

- `id`: The ID of the event.
- `nom`: The name of the event.
- `date`: The date of the event.
- `infrastructure`: The sportive infrastructure where the event takes place.

#### Ticket

- `id`: The ID of the ticket.
- `prix`: The price of the ticket.
- `spectateur`: The spectator who bought the ticket.
- `epreuve`: The event that the ticket is for.
- `etat`: The state of the ticket (paid or reserved or canceled or validated or refused).

#### Sportive infrastructure

- `id`: The ID of the sportive infrastructure.
- `nom`: The name of the sportive infrastructure.
- `adresse`: The address of the sportive infrastructure.
- `capacite`: The capacity of the sportive infrastructure.

#### Delegation

- `id`: The ID of the delegation.
- `nom`: The name of the delegation.
- `nombreMedailleOr`: The number of gold medals won by the delegation.
- `nombreMedailleArgent`: The number of silver medals won by the delegation.
- `nombreMedailleBronze`: The number of bronze medals won by the delegation.

### Authentication

The API uses Spring Security for authentication. The authentication is done using sessions.

There are 2 classes that define the security configuration:

- [`SecurityConfig`](src/main/java/com/MIAGE/jeuxmiagiques/authentification/SecurityConfig.java): The security configuration class.
- [`CorsConfig`](src/main/java/com/MIAGE/jeuxmiagiques/authentification/CorsConfig.java): The CORS configuration class.

The API has 2 roles: `ROLE_USER` and `ROLE_ADMIN` (the `ROLE_ADMIN` role is used for organizers).

The API has 2 endpoints for authentication:

- `POST /login`: Log in a user. Creates a new session and returns a session id.
- `POST /logout`: Log out a user. Deletes the session.

The API has 1 endpoint for registration:

- `POST /register`: Register a new user. Creates a new user (spectator or organizer).

### Controllers

The API has 1 controller for each model (except for the `User` model, which is abstract), and 2 controllers for authentication:

- [`SpectateurController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/SpectateurController.java): Controller for the `Spectator` model.
- [`OrganisateurController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/OrganisateurController.java): Controller for the `Organizer` model.
- [`ParticipantController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/ParticipantController.java): Controller for the `Participant` model.
- [`EpreuveController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/EpreuveController.java): Controller for the `Event` model.
- [`BilletController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/BilletController.java): Controller for the `Ticket` model.
- [`InfrastructureSportiveController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/InfrastructureSportiveController.java): Controller for the `SportiveInfrastructure` model.
- [`DelegationController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/DelegationController.java): Controller for the `Delegation` model.
- [`ResultatController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/ResultatController.java): Controller for the `Resultat` model.
- [`LoginController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/LoginController.java): Controller for the login endpoint.
- [`RegisterController`](src/main/java/com/MIAGE/jeuxmiagiques/controller/RegisterController.java): Controller for the register endpoint.

Each controller has the following endpoints:

- `GET`: Get all objects (`/api/{model}s` in all controllers except for the authentication controllers, which have no `GET` endpoint)
- `GET {id}`: Get an object by its ID (`/api/{model}s/{id}` in all controllers except for the authentication controllers, which have no `GET {id}` endpoint)
- `POST`: Create a new object (`/api/{model}s` in all controllers except for the authentication controllers, which have `POST /login` and `POST /register` endpoints)
- `PUT {id}`: Update an object (`/api/{model}s/{id}` in all controllers except for the authentication controllers, which have no `PUT {id}` endpoint)
- `DELETE {id}`: Delete an object (`/api/{model}s/{id}` in all controllers except for the authentication controllers, which have no `DELETE {id}` endpoint)

### Services

The API has 1 service for each model:

- [`CustomUserDetailsService`](src/main/java/com/MIAGE/jeuxmiagiques/service/CustomUserDetailsService.java): Service for the `User` model.
- [`SpectateurService`](src/main/java/com/MIAGE/jeuxmiagiques/service/SpectateurService.java): Service for the `Spectator` model.
- [`OrganisateurService`](src/main/java/com/MIAGE/jeuxmiagiques/service/OrganisateurService.java): Service for the `Organizer` model.
- [`ParticipantService`](src/main/java/com/MIAGE/jeuxmiagiques/service/ParticipantService.java): Service for the `Participant` model.
- [`EpreuveService`](src/main/java/com/MIAGE/jeuxmiagiques/service/EpreuveService.java): Service for the `Event` model.
- [`BilletService`](src/main/java/com/MIAGE/jeuxmiagiques/service/BilletService.java): Service for the `Ticket` model.
- [`InfrastructureSportiveService`](src/main/java/com/MIAGE/jeuxmiagiques/service/InfrastructureSportiveService.java): Service for the `SportiveInfrastructure` model.
- [`DelegationService`](src/main/java/com/MIAGE/jeuxmiagiques/service/DelegationService.java): Service for the `Delegation` model.
- [`ResultatService`](src/main/java/com/MIAGE/jeuxmiagiques/service/ResultatService.java): Service for the `Resultat` model.

### Repositories

The API has 1 repository for each model:

- [`UserRepository`](src/main/java/com/MIAGE/jeuxmiagiques/repository/UserRepository.java): Repository for the `User` model.
- [`SpectateurRepository`](src/main/java/com/MIAGE/jeuxmiagiques/repository/SpectateurRepository.java): Repository for the `Spectator` model.
- [`OrganisateurRepository`](src/main/java/com/MIAGE/jeuxmiagiques/repository/OrganisateurRepository.java): Repository for the `Organizer` model.
- [`ParticipantRepository`](src/main/java/com/MIAGE/jeuxmiagiques/repository/ParticipantRepository.java): Repository for the `Participant` model.
- [`EpreuveRepository`](src/main/java/com/MIAGE/jeuxmiagiques/repository/EpreuveRepository.java): Repository for the `Event` model.
- [`BilletRepository`](src/main/java/com/MIAGE/jeuxmiagiques/repository/BilletRepository.java): Repository for the `Ticket` model.
- [`InfrastructureSportiveRepository`](src/main/java/com/MIAGE/jeuxmiagiques/repository/InfrastructureSportiveRepository.java): Repository for the `SportiveInfrastructure` model.
- [`DelegationRepository`](src/main/java/com/MIAGE/jeuxmiagiques/repository/DelegationRepository.java): Repository for the `Delegation` model.
- [`ResultatRepository`](src/main/java/com/MIAGE/jeuxmiagiques/repository/ResultatRepository.java): Repository for the `Resultat` model.

### TranslationUnits (DTOs)

We use TranslationUnits to convert the DTOs to entities in requests.

- [`BilletById`](src/main/java/com/MIAGE/jeuxmiagiques/translationUnit/BilletById.java): TranslationUnit for the `Ticket` model.
- [`ParticipantById`](src/main/java/com/MIAGE/jeuxmiagiques/translationUnit/ParticipantById.java): TranslationUnit for the `Participant` model.
- [`ResultatById`](src/main/java/com/MIAGE/jeuxmiagiques/translationUnit/ResultatById.java): TranslationUnit for the `Resultat` model.
- [`LoginRequest`](src/main/java/com/MIAGE/jeuxmiagiques/translationUnit/LoginRequest.java): TranslationUnit for the `User` model (used for login).

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- lombok
- Docker
- Docker Compose
- Maven (for dependency management)
- Git (for version control)
- MySQL

## Contributors

- [Younes EL ARJOUNI](https://github.com/younest9)
- [Anas SGHIR](https://github.com/ITSsghir)