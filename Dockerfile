# Start with a base image containing Java runtime
FROM openjdk:21-jdk

# Add a volume to allow container logs to stream
VOLUME /tmp

# Add the JAR to the container
ARG JAR_FILE=target/nba-player-stats-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Run the JAR
ENTRYPOINT ["java","-jar","/app.jar"]