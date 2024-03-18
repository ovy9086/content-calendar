### Spring Boot 2023

Spring boot starter project following Dan Vega's crash [course](https://www.youtube.com/watch?v=UgX5lgv4uVM&t=8320s&ab_channel=DanVega).

The project is a REST API that uses Spring Data to connect to a postgres database to CRUD data.

Run the docker image to boot-up a docker with a postgres DB, and then start the app via gradle:
```
docker-compose up

gradlew bootRun
```

The REST API starts on : http://localhost:9090/api/

You can also browse the Spring Actuator at : http://localhost:9090/actuator 

Browse more resources in `docs/`