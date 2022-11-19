FROM openjdk:11
EXPOSE 8891
ADD target/*.jar app.jar
ENV JAVA_OPTS="-Xss:32m"
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]