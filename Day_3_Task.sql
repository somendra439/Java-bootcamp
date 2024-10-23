create database db_sgvu;
use db_sgvu;
show tables;
create table student(id int primary key, name varchar(100), mobile_no varchar(20),email_id varchar(100));
desc student;
insert into student values(101, "aman", "9898765645", "aman@gmail.com");
select*from student;
insert into student values(102, "Rohit", "9898765635", "Rohit@gmail.com");
create table users(id int primary key auto_increment, username varchar(100), password varchar(100), balance decimal(10,2));
insert into users(username, password, balance) values("Rohit", "23456", "200000");
select*from users;
update users set balance = '1200000' where id = 3;

