FROM openjdk:18
WORKDIR /app
COPY ./target/Sample-0.0.1-SNAPSHOT.jar /app
EXPOSE 4000
CMD ["java", "-jar", "Sample-0.0.1-SNAPSHOT.jar"]