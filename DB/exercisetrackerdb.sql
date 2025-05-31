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
-- Table `exercise_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exercise_type` ;

CREATE TABLE IF NOT EXISTS `exercise_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(2000) NOT NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(2000) NULL,
  `team_sport` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exercise`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exercise` ;

CREATE TABLE IF NOT EXISTS `exercise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `notes` TEXT NULL,
  `duration_in_hours` DOUBLE NULL,
  `average_heart_rate` INT NULL,
  `calories_burned` INT NULL,
  `exercise_date` DATETIME NULL,
  `exercise_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_exercise_exercise_type1_idx` (`exercise_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_exercise_exercise_type1`
    FOREIGN KEY (`exercise_type_id`)
    REFERENCES `exercise_type` (`id`)
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
-- Data for table `exercise_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `exercisedb`;
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (1, 'Weightlifting', NULL, NULL, NULL);
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (2, 'Pilates', NULL, NULL, NULL);
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (3, 'Yoga', NULL, NULL, NULL);
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (4, 'Running', NULL, NULL, NULL);
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (5, 'Climbing', NULL, NULL, NULL);
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (6, 'Basketball', NULL, NULL, 1);
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (7, 'Volleyball', NULL, NULL, 1);
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (8, 'Hockey', NULL, NULL, 1);
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (9, 'Baseball', NULL, NULL, 1);
INSERT INTO `exercise_type` (`id`, `name`, `description`, `image_url`, `team_sport`) VALUES (10, 'Kickball', NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `exercise`
-- -----------------------------------------------------
START TRANSACTION;
USE `exercisedb`;
INSERT INTO `exercise` (`id`, `notes`, `duration_in_hours`, `average_heart_rate`, `calories_burned`, `exercise_date`, `exercise_type_id`) VALUES (1, '', .75, 98, 231, '2025-05-30', 3);
INSERT INTO `exercise` (`id`, `notes`, `duration_in_hours`, `average_heart_rate`, `calories_burned`, `exercise_date`, `exercise_type_id`) VALUES (2, '', NULL, NULL, NULL, NULL, 4);
INSERT INTO `exercise` (`id`, `notes`, `duration_in_hours`, `average_heart_rate`, `calories_burned`, `exercise_date`, `exercise_type_id`) VALUES (3, '', NULL, NULL, NULL, NULL, 5);
INSERT INTO `exercise` (`id`, `notes`, `duration_in_hours`, `average_heart_rate`, `calories_burned`, `exercise_date`, `exercise_type_id`) VALUES (4, '', NULL, NULL, NULL, NULL, 1);
INSERT INTO `exercise` (`id`, `notes`, `duration_in_hours`, `average_heart_rate`, `calories_burned`, `exercise_date`, `exercise_type_id`) VALUES (5, '', NULL, NULL, NULL, NULL, 1);
INSERT INTO `exercise` (`id`, `notes`, `duration_in_hours`, `average_heart_rate`, `calories_burned`, `exercise_date`, `exercise_type_id`) VALUES (6, '', NULL, NULL, NULL, NULL, 2);

COMMIT;

