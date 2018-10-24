# Mysql change data capture poc - Spring Boot

Proof of concept to receive mysql events when data modification occurs.

## Setup PoC Apps

1. Run docker compose. Docker compose will create two mysql containers with master-slave configuration.

    docker-compose up

2. Create some database, table and data.
3. Run Spring Boot aplication.

## Spring Boot

https://docs.spring.io/spring-boot/docs/2.0.6.RELEASE/reference/htmlsingle/

## Maxwell library

http://maxwells-daemon.io/
https://github.com/zendesk/maxwell

## Mysql-binlog-connector-java

https://github.com/shyiko/mysql-binlog-connector-java

## MySQL Master-Slave docker compose

https://github.com/tarunlalwani/docker-compose-mysql-master-slave 

## Similar projects

https://github.com/wushujames/mysql-cdc-projects/wiki