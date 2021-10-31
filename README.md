# Magic card prices v2
![Basic CI](https://github.com/williamokano/magic-card-prices-2/workflows/Basic%20CI/badge.svg)  

New version of git magic card prices, this time, written in kotlin

## How to install
Just run `./gradlew clean build`

## Building the docker image
Just run `docker build`

## Executing the project
You can have 4 main ways to execute the project

### Running from gradle
Running locally with gradle is easy since it runs on top of spring boot, just run `./gradlew bootRun`.  

You will need to run the database locally and configure it correctly on your application properties file.

### Running from the build
You can build the java file, which is a fatjar, and then run `java -jar build/application.jar`.  

You will need to run the database locally and configure it correctly through environment variables.

### Running from the docker image
For running from the docker image, you will need to build the image first running `docker build`.  

After that, you can simply execute `docker run -p 8080 :8080 magic-card-prices:latest`.  

Don't forget to configure your database using environment variables.


### Running from docker compose
By far the easiest way, just execute `docker compose up`. You can add the parameter ` -d` if you wish to run it as a daemon.
