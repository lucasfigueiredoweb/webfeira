FROM openjdk:16

ARG APP_VERSION
ENV VERSION=$APP_VERSION

COPY ./target/classes/* ./app/lib/
COPY ./target/web-feira-$VERSION.jar ./app

EXPOSE 8080

ENTRYPOINT exec java $JAVA_OPTS -jar /app/web-feira-$VERSION.jar
