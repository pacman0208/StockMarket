FROM java:8
MAINTAINER lee <q-man23@163.com>
VOLUME /tmp
ADD ./target/EurekaServerService-0.0.1-SNAPSHOT.jar euraka.jar
RUN bash -c 'touch /euraka.jar'
ENTRYPOINT ["java","-jar","/euraka.jar"]