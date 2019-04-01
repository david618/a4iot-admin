# A4IOT Admin 

## Created API 

Created API using [Swagger Editor](https://swagger.io/tools/swagger-editor/)

Per instruction on [swagger-editor GitHub](https://github.com/swagger-api/swagger-editor) used Docker.

```
docker run -d -p 80:8080 swaggerapi/swagger-editor
```

Created the API using browser connecting to Localhost.  From web app exported [swagger-a4iot.yaml](./swagger-a4iot.yaml).


## Generated Application Stubs

From Swagger Editor used Generate Server to create code stubs for "spring".  Then download the zip file ```spring-server-generated.zip```. Unzip the file.  Unzips to folder `spring-server`.  To test the api.


### Build
```
cd spring-server
mvn install
```

### Run
```
java -jar target/swagger-spring-1.0.0.jar
```

### Browse and Test

From browser navigate to localhost:8080/v2.  You should see the Swagger UI page.  You can then click on the various paths and test them.  The default reponses return HTTP 501.  

The generated code does provide some limited validation it returns. For example if you try to POST to 'tenant/{tenant-id}' with azure-num-instances less than zero the UI will return a HTTP 400 "Bad Request"

## Create IntelliJ Project

Import the project.

Change Folder Name (e.g. a4iot-admin)

Import the Project.

Add code to implement operations.











