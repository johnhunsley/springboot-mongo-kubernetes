# springboot-mongo-kubernetes
A Spring Boot Rest API which accepts and consumes data to persist in Mongo. This example uses Kubernetes config-map and secrets 

##Run locally without Kubernetes
Create and start a mongodb on host port 27888 outside of Kubernetes:

docker pull mongo

docker run -d  --name mongo-on-docker  -p 27888:27017 -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret mongo

spring-boot:mvn run

Send in some POST requests and populate the mongodb to localhost:8080/snacks

Read them back with a GET request to localhost:8080/snacks
