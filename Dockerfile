FROM java
COPY ./mysql-connector-java-8.0.13.jar /mysql-connector-java-8.0.13.jar
COPY ./MysqlCon.java /MysqlCon.java
WORKDIR /
RUN javac MysqlCon.java
CMD ["java", "-classpath", "mysql-connector-java-8.0.13.jar:.","MysqlCon"]
