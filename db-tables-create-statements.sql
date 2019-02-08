create schema test;
use test;
-- Categories table create statement --
CREATE TABLE `test`.`categories` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`)
);

-- Users table create statement --
CREATE TABLE `test`.`users` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NULL,
  `CNIC` VARCHAR(20) NULL,
  `Mobile` VARCHAR(20) NULL,
  `Address` VARCHAR(200) NULL,
  PRIMARY KEY (`Id`));

-- Books table create statement --
CREATE TABLE `test`.`books` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Category_id` INT(11) NULL,
  `Name` VARCHAR(100) NULL,
  `Auther_name` VARCHAR(100) NULL,
  PRIMARY KEY (`Id`));