FROM openjdk:11-jdk

COPY /target/lab2-1.0.jar /lab2-1.0.jar
ENTRYPOINT ["java"]
CMD ["-jar", "lab2-1.0.jar"]
EXPOSE 8080