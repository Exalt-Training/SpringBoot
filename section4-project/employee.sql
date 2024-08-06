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