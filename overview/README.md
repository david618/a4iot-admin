## Overview a4iot admin

### Started with Swagger  

Created API using [SwaggerHub](https://app.swaggerhub.com) or using [Docker Image](https://github.com/swagger-api/swagger-editor)

#### Overview of Swagger
- Paths 
- Operations (Get, Post, Put, Delete)
- Parameters 
- Definitions

#### Export Created Server Stub

- Spring (Tried serveral Spring was easiest to work with; maven project)
- Play (Required several tweaks to get working; relied on sbt instead of maven); only available from Docker Image


### Created App

Steps 
- Extracted into a project folder (a4iot-admin)
- Changed name in pom.xml (a4iot-admin)
- Imported into IntelliJ (IDE)
- Stub Controllers is where you add code for implementation
- Added to Java Package (com.esri.a4iot) to hold implementation 
  - Keeps implementation portable. Easily moved from Spring, Play, etc. stubs
  - When updating the API only small amount of code in Controllers needs to be changed
- Modified Stub Controllers to call implementation

Code checked into [github](https://github.com/david618/a4iot-admin/) will eventually be part of devtopia/real-time-gis.

### Updated Scripts

- Added support.sh (Common Variables and Logging Functions)
- Modified code to create Tenant folder (/tenants/{tenant-id})
- Code captures Tenant info in Tenant Folder (manifests; status; log; create.log; key)

### Deployed to VM  

- Ubuntu 18.04
- Apache Web Server
- CertBot/Let's Encrypt
- Added Http basic Authentication (requires username/password to access)
- Ran Web App (a4iot-admin)
- Proxy from Web Server to Web App

https://a4iot-admin.westus2.cloudapp.azure.com

This app will be Dockerized and deployed as a pod on Regional Admin K8s



