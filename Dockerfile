FROM openjdk:11
EXPOSE 8080
ADD target/Nov19SpringbootJPA-0.0.1-SNAPSHOT.war Nov19SpringbootJPA-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","Nov19SpringbootJPA-0.0.1-SNAPSHOT.war" ]