FROM maven:3.9.9-amazoncorretto-21 AS builder

WORKDIR /app

# Copy shared module first
COPY bancassurance-shared ./bancassurance-shared

# Copy this service's files
COPY bancassurance-payments-service/pom.xml ./pom.xml
COPY bancassurance-payments-service/src ./src
COPY bancassurance-payments-service/libs ./libs

# Build the shared module first
WORKDIR /app/bancassurance-shared
RUN mvn clean install -DskipTests

# Install the security library and build this service
WORKDIR /app
RUN mvn install:install-file \
    -Dfile=libs/security-library-0.0.1-SNAPSHOT.jar \
    -DgroupId=com.nmb.bancassurance \
    -DartifactId=security-library \
    -Dversion=0.0.1-SNAPSHOT \
    -Dpackaging=jar

RUN mvn clean package -DskipTests

# Minimal runtime image
FROM amazoncorretto:21-alpine

# Create non-root user for security
RUN addgroup -g 1001 -S appgroup && \
    adduser -u 1001 -S appuser -G appgroup

WORKDIR /app

# Copy only the built JAR from build stage
COPY --from=builder /app/target/*.jar app.jar

# Change ownership to non-root user
RUN chown -R appuser:appgroup /app
USER appuser

# Expose port
EXPOSE 8082

# Use exec form and add JVM optimization flags
ENTRYPOINT ["java", \
    "-XX:+UseContainerSupport", \
    "-XX:MaxRAMPercentage=75.0", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-jar", "app.jar"]