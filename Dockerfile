FROM java:8
FROM tomcat:8-jre8
ADD ./target/rwdapp.war /usr/local/tomcat/webapps/rwdapp.war
ADD ./tomcat-users.xml /usr/local/tomcat/conf
RUN mkdir /usr/local/tomcat/log
CMD ["catalina.sh","run"]
EXPOSE 8080