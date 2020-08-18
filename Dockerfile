FROM openjdk:8
ADD . .
CMD ./gradlew build
CMD ./gradlew run
#docker build -f Dockerfile -t java-app:e2e .
#docker run java-app:e2e