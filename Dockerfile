FROM java
ADD /build/libs/altidemopipeline-0.0.1-SNAPSHOT.jar //
ENTRYPOINT ["java", "-jar", "/altidemopipeline-0.0.1-SNAPSHOT.jar"]
