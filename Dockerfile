# Docker image for springboot file run
# VERSION 0.0.1
# Author: eangulee
# 基础镜像使用java
FROM openjdk:11
# 作者
MAINTAINER Robin <rorbbin@163.com>
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp
# 将jar包添加到容器中并更名为app.jar
ADD ./target/demo-0.0.1-SNAPSHOT.jar app.jar
# 运行jar包
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# run command
# 1. docker build -t springbootdocker .
# 2. docker run -d -p 8080:8080 springbootdocker

# MySQL
# docker pull mysql:8.0.23
# docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:8.0.23
# docker exec -it mysql bash
# mysql -uroot -p123456

#GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';
# FLUSH PRIVILEGES;

# create user 'lan'@'%' identified by 'lan';
# ALTER USER 'lan'@'%' IDENTIFIED WITH mysql_native_password BY 'Pa$$word1@';
# FLUSH PRIVILEGES;