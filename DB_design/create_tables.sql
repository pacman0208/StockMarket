-- MySQL Script generated by MySQL Workbench
-- Sat May  9 12:05:47 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Users` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Users` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(30) NULL,
  `user_type` VARCHAR(2) NULL COMMENT '0:user\n1:admin\n',
  `email` VARCHAR(50) NULL,
  `mobile_number` VARCHAR(20) NULL,
  `confirmed` VARCHAR(2) NULL,
  `last_chg_tsp` DATETIME NULL,
  `create_tsp` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sectors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sectors` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sectors` (
  `id` INT NOT NULL,
  `sector_name` VARCHAR(100) NULL,
  `last_chg_tsp` DATETIME NULL,
  `create_tsp` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Company` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Company` (
  `id` INT NOT NULL,
  `Sectors_id` INT NOT NULL,
  `stock_code` VARCHAR(20) NULL,
  `company_name` VARCHAR(100) NULL,
  `turnover` FLOAT NULL,
  `ceo` VARCHAR(50) NULL,
  `board_of_directors` VARCHAR(45) NULL,
  `list_in_exchanges` VARCHAR(2) NULL COMMENT 'Is list in exchanges:\n0: yes\n1:no',
  `brief_intro` VARCHAR(1000) NULL,
  `last_chg_tsp` DATETIME NULL,
  `create_tsp` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Company_Sectors_idx` (`Sectors_id` ASC) VISIBLE,
  UNIQUE INDEX `stock_code_UNIQUE` (`stock_code` ASC) VISIBLE,
  CONSTRAINT `fk_Company_Sectors`
    FOREIGN KEY (`Sectors_id`)
    REFERENCES `mydb`.`Sectors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`StockExchange`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`StockExchange` ;

CREATE TABLE IF NOT EXISTS `mydb`.`StockExchange` (
  `id` INT NOT NULL,
  `exchange_name` VARCHAR(50) NULL,
  `brief` VARCHAR(200) NULL,
  `contact_address` VARCHAR(500) NULL,
  `remarks` VARCHAR(1000) NULL,
  `last_chg_tsp` DATETIME NULL,
  `create_tsp` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`StockPrice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`StockPrice` ;

CREATE TABLE IF NOT EXISTS `mydb`.`StockPrice` (
  `id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `stockexchange_id` INT NOT NULL,
  `current_price` FLOAT NULL,
  `date` DATE NULL,
  `time` TIME NULL,
  `last_chg_tsp` DATETIME NULL,
  `create_tsp` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_StockPrice_Company1_idx` (`company_id` ASC) VISIBLE,
  INDEX `fk_StockPrice_StockExchange1_idx` (`stockexchange_id` ASC) VISIBLE,
  CONSTRAINT `fk_StockPrice_Company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `mydb`.`Company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_StockPrice_StockExchange1`
    FOREIGN KEY (`stockexchange_id`)
    REFERENCES `mydb`.`StockExchange` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`IPODetails`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`IPODetails` ;

CREATE TABLE IF NOT EXISTS `mydb`.`IPODetails` (
  `id` INT NOT NULL,
  `company_name` VARCHAR(100) NULL,
  `exchange_name` VARCHAR(50) NULL,
  `price_per_share` FLOAT NULL,
  `total_num_of_shares` VARCHAR(15) NULL,
  `open_date_time` DATETIME NULL,
  `remarks` VARCHAR(500) NULL,
  `last_chg_tsp` DATETIME NULL,
  `create_tsp` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
