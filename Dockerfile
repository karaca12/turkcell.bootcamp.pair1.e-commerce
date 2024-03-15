#building the app
FROM maven:3.9.6-eclipse-temurin-21 as build
WORKDIR /app
#left dot is for windows and right is for linux
COPY . /app/
RUN mvn clean package -DskipTests


#running the software
FROM eclipse-temurin:21-jdk
COPY --from=build /app/target/turkcell_bootcamp_pair1_e-commerce-0.0.1-SNAPSHOT.jar /app/e-commerce.jar
CMD java -jar /app/e-commerce.jar