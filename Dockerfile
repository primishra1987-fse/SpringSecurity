FROM openjdk:8
ADD springmvcboot-0.0.1-SNAPSHOT.jar simple.jar
EXPOSE 3635
ENTRYPOINT [ "java", "-jar", "simple.jar"]