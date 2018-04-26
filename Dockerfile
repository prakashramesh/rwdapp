FROM java:8
FROM tomcat:8-jre8
ADD ./target/rwdapp.war /usr/local/tomcat/webapps/rwdapp.war
ADD ./tomcat-users.xml /usr/local/tomcat/conf
RUN chgrp -R 0 /usr/local/tomcat/ && \
    chmod -R g=u /usr/local/tomcat/
RUN mkdir /usr/local/tomcat/log
CMD ["catalina.sh","run"]
EXPOSE 8080