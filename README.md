## Companion Service

### Description

This service is used by a video streaming site to keep track of the most replayed sections of any video.

### Instructions to run the application

1. To run this application locally as a Docker container you need Docker Desktop installed on your machine.
[Docker Desktop] (https://docs.docker.com/desktop/install/mac-install/)


2. Download the image file from Docker Hub : [companion-service](https://hub.docker.com/repository/docker/shridevijpmc/companion-service/general).
3. Run below command.
   1. docker pull shridevijpmc/companion-service
   2. docker run -d --name companion-service -p 9092:9092
4. View and try out different end points by opening  http://localhost:9092/swagger-url.html URL.


##### Download the repo : [myrepo](repo_link)
