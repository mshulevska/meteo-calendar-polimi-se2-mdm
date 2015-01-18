-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema glassfishdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema glassfishdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `glassfishdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `glassfishdb` ;

-- -----------------------------------------------------
-- Table `glassfishdb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glassfishdb`.`User` (
  `Email` VARCHAR(50) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  `Name` VARCHAR(50) NULL,
  `LastName` VARCHAR(50) NULL,
  `Groupname` VARCHAR(50) NULL,
  `CreatedAt` DATETIME NULL,
  PRIMARY KEY (`Email`),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glassfishdb`.`Location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glassfishdb`.`Location` (
  `idLocation` INT NOT NULL AUTO_INCREMENT,
  `StreetName` VARCHAR(100) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `Latitude` TEXT NULL,
  `Longitude` TEXT NULL,
  PRIMARY KEY (`idLocation`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glassfishdb`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glassfishdb`.`Event` (
  `idEvent` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `EventTime` DATETIME NOT NULL,
  `Description` TEXT NULL,
  `Visibility` TINYINT(1) NOT NULL,
  `CreatedAt` DATE NOT NULL,
  `UpdatedAt` DATE NULL,
  `Location_idLocation` INT NOT NULL,
  `User_Email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idEvent`),
  INDEX `fk_Event_Location1_idx` (`Location_idLocation` ASC),
  INDEX `fk_Event_User1_idx` (`User_Email` ASC),
  CONSTRAINT `fk_Event_Location1`
    FOREIGN KEY (`Location_idLocation`)
    REFERENCES `glassfishdb`.`Location` (`idLocation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_User1`
    FOREIGN KEY (`User_Email`)
    REFERENCES `glassfishdb`.`User` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glassfishdb`.`JoinEvent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glassfishdb`.`JoinEvent` (
  `Event_idEvent` INT NOT NULL,
  `User_Email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Event_idEvent`, `User_Email`),
  INDEX `fk_JoinEvent_Event1_idx` (`Event_idEvent` ASC),
  INDEX `fk_JoinEvent_User1_idx` (`User_Email` ASC),
  CONSTRAINT `fk_JoinEvent_Event1`
    FOREIGN KEY (`Event_idEvent`)
    REFERENCES `glassfishdb`.`Event` (`idEvent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_JoinEvent_User1`
    FOREIGN KEY (`User_Email`)
    REFERENCES `glassfishdb`.`User` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glassfishdb`.`Invitation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glassfishdb`.`Invitation` (
  `idInvitation` INT NOT NULL AUTO_INCREMENT,
  `Event_idEvent` INT NOT NULL,
  `FromUser` VARCHAR(50) NOT NULL,
  `ToUser` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idInvitation`),
  INDEX `fk_Invitation_Event1_idx` (`Event_idEvent` ASC),
  INDEX `fk_Invitation_User1_idx` (`FromUser` ASC),
  INDEX `fk_Invitation_User2_idx` (`ToUser` ASC),
  CONSTRAINT `fk_Invitation_Event1`
    FOREIGN KEY (`Event_idEvent`)
    REFERENCES `glassfishdb`.`Event` (`idEvent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invitation_User1`
    FOREIGN KEY (`FromUser`)
    REFERENCES `glassfishdb`.`User` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invitation_User2`
    FOREIGN KEY (`ToUser`)
    REFERENCES `glassfishdb`.`User` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
