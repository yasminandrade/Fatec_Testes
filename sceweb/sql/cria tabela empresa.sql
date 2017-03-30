-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sceweb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sceweb` ;

-- -----------------------------------------------------
-- Schema sceweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sceweb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sceweb` ;

-- -----------------------------------------------------
-- Table `sceweb`.`Empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sceweb`.`Empresa` ;

CREATE TABLE IF NOT EXISTS `sceweb`.`Empresa` (
  `cnpj` VARCHAR(14) NOT NULL COMMENT '',
  `nomeDaEmpresa` VARCHAR(45) NULL COMMENT '',
  `nomeFantasia` VARCHAR(45) NULL COMMENT '',
  `endereco` VARCHAR(45) NULL COMMENT '',
  `telefone` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`cnpj`)  COMMENT '')
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
