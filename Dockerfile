FROM openjdk:8
VOLUME /tmp
ADD target/simple_user_groups_app-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]