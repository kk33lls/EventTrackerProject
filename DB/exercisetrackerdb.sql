-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema exercisedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `exercisedb` ;

-- -----------------------------------------------------
-- Schema exercisedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `exercisedb` DEFAULT CHARACTER SET utf8 ;
USE `exercisedb` ;

-- -----------------------------------------------------
-- Table `team sports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `team sports` ;

CREATE TABLE IF NOT EXISTS `team sports` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exercise`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exercise` ;

CREATE TABLE IF NOT EXISTS `exercise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(2000) NOT NULL,
  `duration` DOUBLE NULL,
  `average_heart_rate` INT NULL,
  `calories_burned` INT NULL,
  `team sports_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_exercise_team sports_idx` (`team sports_id` ASC) VISIBLE,
  CONSTRAINT `fk_exercise_team sports`
    FOREIGN KEY (`team sports_id`)
    REFERENCES `team sports` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user1@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user1'@'localhost' IDENTIFIED BY 'user1';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user1'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `team sports`
-- -----------------------------------------------------
START TRANSACTION;
USE `exercisedb`;
INSERT INTO `team sports` (`id`, `name`) VALUES (1, 'Basketball');
INSERT INTO `team sports` (`id`, `name`) VALUES (2, 'Volleyball');
INSERT INTO `team sports` (`id`, `name`) VALUES (3, 'Baseball');
INSERT INTO `team sports` (`id`, `name`) VALUES (4, 'Soccer');
INSERT INTO `team sports` (`id`, `name`) VALUES (5, 'Kickball');
INSERT INTO `team sports` (`id`, `name`) VALUES (6, 'Hockey');

COMMIT;


-- -----------------------------------------------------
-- Data for table `exercise`
-- -----------------------------------------------------
START TRANSACTION;
USE `exercisedb`;
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`, `team sports_id`) VALUES (1, 'Weightlifting', NULL, NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`, `team sports_id`) VALUES (2, 'Pilates', NULL, NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`, `team sports_id`) VALUES (3, 'Yoga', NULL, NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`, `team sports_id`) VALUES (4, 'Climbing', NULL, NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`, `team sports_id`) VALUES (5, 'Running', NULL, NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`, `team sports_id`) VALUES (6, 'Team Sports', NULL, NULL, NULL, NULL);

COMMIT;

