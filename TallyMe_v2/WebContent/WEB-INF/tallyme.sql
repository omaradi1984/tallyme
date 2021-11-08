-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tallyme
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tallyme
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tallyme` DEFAULT CHARACTER SET utf8 ;
USE `tallyme` ;

-- -----------------------------------------------------
-- Table `tallyme`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallyme`.`USER` (
  `UUID` CHAR(40) NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `EmailAddress` VARCHAR(45) NULL,
  PRIMARY KEY (`UUID`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tallyme`.`COUNTLOG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallyme`.`COUNTLOG` (
  `UUID` CHAR(40) NOT NULL,
  `Timestamp` DATE NULL,
  `Location` VARCHAR(140) NULL,
  `UserUUID` CHAR(40) NOT NULL,
  PRIMARY KEY (`UUID`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE,
  INDEX `UserUUID_idx` (`UserUUID` ASC) VISIBLE,
  CONSTRAINT `UserUUID`
    FOREIGN KEY (`UserUUID`)
    REFERENCES `tallyme`.`USER` (`UUID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tallyme`.`COUNT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallyme`.`COUNT` (
  `UUID` CHAR(40) NOT NULL,
  `Timestamp` DATE NULL,
  `CountLogUUID` CHAR(40) NOT NULL,
  PRIMARY KEY (`UUID`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE,
  INDEX `CountLogUUID_idx` (`CountLogUUID` ASC) VISIBLE,
  CONSTRAINT `CountLogUUID`
    FOREIGN KEY (`CountLogUUID`)
    REFERENCES `tallyme`.`COUNTLOG` (`UUID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

LOCK TABLES `USER` WRITE;
INSERT INTO `USER` VALUES ('ac299eb1-599e-4599-b22b-95e889448793','','Omar','Zohouradi', 'zoho0003@algonquinlive.com', 'zoho0003', '123456'),('d2bbd408-2836-4c96-92b2-0d44210e8502','','John','Deer', 'jdeer123@algonquinlive.com', 'jdeer123', '123456');
UNLOCK TABLES;
