# Étape 1 : Build avec Maven et Eclipse Temurin
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Exécution avec JRE Eclipse Temurin (plus léger)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# On copie le jar généré à l'étape précédente
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]