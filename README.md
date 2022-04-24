# Java-WebApplication-Project
Movie database management system made for a software architecture course. Created microservices in java and follows layered architecture design, deployed to google cloud using Docker and Kubernetes

# Project Overview
Three microservices were created in java, AddMovie, DeleteMovie and FrontEnd. AddMovie service deals with adding movies into SQL Databases while DeleteMovie deletes movies from the database. Both of these services are connected to the FrontEnd service, in which users can make resquest to the other services via REST API. The project utilizes both Asyncrnous(messaging between services to update databases) and sychronous(REST API) requests. Using microservices to design this project means that each service can operate on their own, making it easier to understand and implement further services in the future when compared to Monolithic designed project. Following N layer design archticeture means that each service has Business,Persistence and Helper packages.

# Project Demo (User Login)
![Screen Shot 2022-04-24 at 12 53 15 PM](https://user-images.githubusercontent.com/57304403/164987414-dbee7ea5-82b3-41fe-bc88-e1d91fa2675e.png)

![Screen Shot 2022-04-24 at 12 53 46 PM](https://user-images.githubusercontent.com/57304403/164987442-e2937692-7af2-4976-9986-e977d428c36c.png)

# Project Demo (Manager Login)

![Screen Shot 2022-04-24 at 12 54 20 PM](https://user-images.githubusercontent.com/57304403/164987465-32e8e323-6a75-40db-8799-5f22dd9bc779.png)



# Docker Pods
![Screen Shot 2022-04-24 at 12 51 53 PM](https://user-images.githubusercontent.com/57304403/164987357-804afbc5-0400-432c-be6d-bc9a69f31263.png)


# Working pods deployed using Kubernetes
![Screen Shot 2022-04-24 at 12 50 42 PM](https://user-images.githubusercontent.com/57304403/164987297-d8a0d778-e83e-44cf-b049-98022d7760f1.png)


