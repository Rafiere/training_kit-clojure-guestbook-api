# syntax = docker/dockerfile:1.2
FROM clojure:openjdk-17 AS build

WORKDIR /
COPY . /

RUN clj -Sforce -T:build all

FROM azul/zulu-openjdk-alpine:17

COPY --from=build /target/kit_clojure_guestbook_api-standalone.jar /kit_clojure_guestbook_api/kit_clojure_guestbook_api-standalone.jar

EXPOSE $PORT

ENTRYPOINT exec java $JAVA_OPTS -jar /kit_clojure_guestbook_api/kit_clojure_guestbook_api-standalone.jar
