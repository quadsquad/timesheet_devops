FROM tomcat:latest
ADD target/timesheet_devops.war /usr/local/tomcat/webapps/
EXPOSE 8081
CMD ["catalina.sh", "run"]