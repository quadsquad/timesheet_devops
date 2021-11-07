FROM tomcat:latest
EXPOSE 8088
ADD /target/timesheet_devops.war timesheet_devops.war
CMD ["catalina.sh", "run"]