FROM openjdk:8
EXPOSE 8080 8000
ARG JAR_FILE=target/payroll-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} mgmt-payroll.jar
ADD entrypoint.sh entrypoint.sh
ENTRYPOINT ["sh","/entrypoint.sh"]
