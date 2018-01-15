FROM java
ADD /build/libs/bnym-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java", "-jar", "/bnym-0.0.1-SNAPSHOT.jar"]
