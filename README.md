## Spring Boot Demo

Sample Spring Boot Application with MongoDB
</br></br></br>

## Prerequisites
The application requires a MongoDB instance running on your local machine on port 27017.

For running as a Docker container, Docker should be installed and running.

Java 10 is required for working on the project.

## Run the Project on local
While the Mongo instance is running, run following from the project directory
```
mvn clean install
```

## Run the Project on Docker container
Build the docker image using following:
```
docker build -t demo-local-build .
```
Run instance of the image using following:
```
docker run -p 8080:8080 demo-local-build
```