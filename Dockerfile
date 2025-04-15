FROM yannoff/maven:3-openjdk-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY src ./src
RUN mvn clean package

FROM openjdk:21-slim AS runner
WORKDIR /app

COPY --from=builder /app/target/listaDeTarefas-0.0.1-SNAPSHOT.jar .

ENV SERVER_PORT=8081
ENV DB_URL=jdbc:postgresql://localhost:5432/postgres
ENV DB_USER=postgres
ENV DB_PASSWORD=admin

EXPOSE ${SERVER_PORT}

ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${SERVER_PORT} --spring.datasource.url=${DB_URL}"]