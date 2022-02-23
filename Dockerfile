FROM maven:3.6-jdk-8-alpine as builder
WORKDIR /customer
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package

FROM openjdk:8-jre-alpine
COPY --from=builder /customer/target/*.jar customer.jar
CMD ["java","-jar","/customer.jar"]