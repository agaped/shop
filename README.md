# shop-online

## This is a REST application built with Spring Boot 2 and Angular 7

## Requirements to run it locally:
* Maven >= 3.x
* Java  >= 8
* MySql server with created database shop, scripts are available:
shop\backend\ShopSql.sql
shop\backend\Shop_values.sql,
after that update a file shop\backend\src\main\resources\application.properties
with new username and password

## How to run:
1. git clone 
2. cd shop
3. mvn clean install
4. cd backend
5. mvn spring-boot:run (app runs on port 8081 by default, to change it add a flag 
-Dserver.port=XXXX)

## Technology used:
* Maven
* Java v.8
* node.js v.10.15.3
* npm v.6.4.1
* Angular CLI v.7.3.8
* Spring Boot v.2.1.4
* MySQL 
