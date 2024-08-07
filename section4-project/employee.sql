CREATE SCHEMA `employee`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee`(
	`id` INT NOT NULL AUTO_INCREMENT, 
    `first_name` VARCHAR(45) DEFAULT NULL,
    `last_name` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY(`id`)
);

INSERT INTO `employee` (`first_name`, `last_name`, `email`) VALUES ("riham", "katout", "test1@gmail.com");
INSERT INTO `employee` (`first_name`, `last_name`, `email`) VALUES ("riham", "muneer", "test2@gmail.com");
INSERT INTO `employee` (`first_name`, `last_name`, `email`) VALUES ("muneer", "katout", "test3@gmail.com");


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
	username varchar(50) NOT NULL, 
    password varchar(50) NOT NULL, 
    enabled TINYINT NOT NULL, 
    PRIMARY KEY(`username`)
) ENGINE=InnoDB DEFAULT charset=latin1;

INSERT INTO `users` VALUES ('riham', '{noop}1218', 1), ('ahmad', '{noop}2010', 1), ('siwar', '{noop}2021', 1);

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities`(
	`username` varchar(50) NOT NULL, 
    `authority` varchar(50) NOT NULL, 
    unique KEY `auth_PK` (`username`, `authority`), 
    CONSTRAINT `auth_FK` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities` VALUES ('riham', 'ROLE_ADMIN'), ('ahmad', 'ROLE_EMPLOYEE'), ('siwar', 'ROLE_MANAGER');