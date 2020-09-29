FROM maven:4-jdk-11

ADD . /passwordmanager
WORKDIR /passwordmanager

RUN mvn clean install 

FROM openjdk:11-jdk

MAINTAINER Rafael de Biase

VOLUME /tpm

COPY --from=0 "/passwordmanager/target/passwordmanager-0.0.1-SNAPSHOT.jar" app.jar

CMD [ "sh", "-c", "java -Dserver.port=$PORT -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
