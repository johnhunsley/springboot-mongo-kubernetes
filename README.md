# springboot-mongo-kubernetes
A Spring Boot Rest API which accepts and consumes data to persist in Mongo. This example uses Kubernetes config-map and secrets 

Create and start a mongodb on host port 27888 outside of Kubernetes:

docker pull mongo

docker run -d  --name mongo-on-docker  -p 27888:27017 -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret mongo

