## Spring Boot Demo

Sample Spring Boot Application with MongoDB
</br></br></br>

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