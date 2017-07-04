DROP SCHEMA IF EXISTS test;
CREATE SCHEMA `test` DEFAULT CHARACTER SET utf8;

CREATE TABLE `test`.`User` (
`id` INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(25) NOT NULL,
`age` INT NOT NULL,
`isAdmin` BIT NOT NULL DEFAULT false,
`createdDate` TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Taras', '26');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Stepan', '35');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Oleg', '19');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Katya', '16');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Petro', '22');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Denis', '24');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Andriy', '40');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Vlad', '20');
INSERT INTO `test`.`User` (`NAME`, `AGE`, `isAdmin`) VALUES ('Pasha', '20',true);
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Orest', '21');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Mykola', '23');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Dima', '56');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Galya', '21');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Nastya', '23');
INSERT INTO `test`.`User` (`NAME`, `AGE`) VALUES ('Tanya', '29');
