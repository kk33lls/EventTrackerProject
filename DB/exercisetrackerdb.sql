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
-- Table `exercise`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exercise` ;

CREATE TABLE IF NOT EXISTS `exercise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(2000) NOT NULL,
  `duration` DOUBLE NULL,
  `average_heart_rate` INT NULL,
  `calories_burned` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `team_sports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `team_sports` ;

CREATE TABLE IF NOT EXISTS `team_sports` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(2000) NULL,
  `exercise_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_team_sports_exercise_idx` (`exercise_id` ASC) VISIBLE,
  CONSTRAINT `fk_team_sports_exercise`
    FOREIGN KEY (`exercise_id`)
    REFERENCES `exercise` (`id`)
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
-- Data for table `exercise`
-- -----------------------------------------------------
START TRANSACTION;
USE `exercisedb`;
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`) VALUES (1, 'Weightlifting', NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`) VALUES (2, 'Pilates', NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`) VALUES (3, 'Yoga', NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`) VALUES (4, 'Climbing', NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`) VALUES (5, 'Running', NULL, NULL, NULL);
INSERT INTO `exercise` (`id`, `name`, `duration`, `average_heart_rate`, `calories_burned`) VALUES (6, 'Team Sports', NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `team_sports`
-- -----------------------------------------------------
START TRANSACTION;
USE `exercisedb`;
INSERT INTO `team_sports` (`id`, `name`, `exercise_id`) VALUES (1, 'Basketball', NULL);
INSERT INTO `team_sports` (`id`, `name`, `exercise_id`) VALUES (2, 'Volleyball', NULL);
INSERT INTO `team_sports` (`id`, `name`, `exercise_id`) VALUES (3, 'Baseball', NULL);
INSERT INTO `team_sports` (`id`, `name`, `exercise_id`) VALUES (4, 'Soccer', NULL);
INSERT INTO `team_sports` (`id`, `name`, `exercise_id`) VALUES (5, 'Kickball', NULL);
INSERT INTO `team_sports` (`id`, `name`, `exercise_id`) VALUES (6, 'Hockey', NULL);
INSERT INTO `team_sports` (`id`, `name`, `exercise_id`) VALUES (DEFAULT, NULL, NULL);

COMMIT;

