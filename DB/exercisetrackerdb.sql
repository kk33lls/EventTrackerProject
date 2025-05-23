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
  PRIMARY KEY (`id`))
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
INSERT INTO `exercise` (`id`, `name`) VALUES (1, 'Weightlifting');
INSERT INTO `exercise` (`id`, `name`) VALUES (2, 'Pilates');
INSERT INTO `exercise` (`id`, `name`) VALUES (3, 'Yoga');
INSERT INTO `exercise` (`id`, `name`) VALUES (4, 'Team Sports');
INSERT INTO `exercise` (`id`, `name`) VALUES (5, 'Climbing');
INSERT INTO `exercise` (`id`, `name`) VALUES (6, 'Running');

COMMIT;

