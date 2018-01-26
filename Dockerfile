FROM java
ADD /build/libs/bnym-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java", "-jar", "/bnympipeline-0.0.1-SNAPSHOT.jar"]
