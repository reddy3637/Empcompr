FROM openjdk:11
EXPOSE 8087
ADD target/EmployeeData-Comp-Springboot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/EmployeeData-Comp-Springboot-0.0.1-SNAPSHOT.jar"]
