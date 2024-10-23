create database db_joy;
use db_joy;
show tables;
CREATE TABLE Users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), balance DECIMAL(10, 2));
INSERT INTO Users (name, balance) VALUES ('Somu', 70076.50);
INSERT INTO Users (name, balance) VALUES ('Sonu', 63505.00);
INSERT INTO Users (name, balance) VALUES ('Sunny', 82004.35);

SET SQL_SAFE_UPDATES = 0;

UPDATE Users SET balance = 65000.00 WHERE name = 'Somu';

DELETE FROM Users WHERE name = 'Sunny';

SELECT * FROM Users;
