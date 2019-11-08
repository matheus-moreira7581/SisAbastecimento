-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SisAbastecimento
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SisAbastecimento` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `SisAbastecimento` ;

-- -----------------------------------------------------
-- Table `SisAbastecimento`.`abastecimento`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `SisAbastecimento`.`abastecimento` (
  `id_abastecimento` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `estado` VARCHAR(50) not null,
  `municipio` VARCHAR(500) not null,
  PRIMARY KEY (`id_abastecimento`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `SisAbastecimento`.`represa`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `SisAbastecimento`.`represa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nomeRepresa` VARCHAR(50) NOT NULL,
  `volumeUtil` INT NOT NULL,
  `volumeReservaTecnica` INT NOT NULL,
  `id_abastecimento` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_represa_abastecimento_idx` (`id_abastecimento` ASC),
  CONSTRAINT `fk_represa_abastecimento` FOREIGN KEY (`id_abastecimento`)
  REFERENCES `SisAbastecimento`.`abastecimento` (`id_abastecimento`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SisAbastecimento`.`volumearmazenado` (
	`id_volumeArmazenado` INT NOT NULL AUTO_INCREMENT,
    `id_represa` INT NOT NULL,
    `volumeArmazenado` INT NOT NULL,
    PRIMARY KEY (`id_volumeArmazenado`),
    CONSTRAINT `fk_volumearmazenado_represa` FOREIGN KEY (`id_represa`)
    REFERENCES `SisAbastecimento`.`represa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;

insert into abastecimento values(null, 'Abastecimento 1', 'Estado 1', 'Municipio 1, Municipio 2, Municipio 3, Municipio 4, Municipio 5,');
insert into abastecimento values(null, 'Abastecimento 2', 'Estado 2', 'Municipio 1, Municipio 2, Municipio 3, Municipio 4, Municipio 5,');
insert into abastecimento values(null, 'Abastecimento 3', 'Estado 3', 'Municipio 1, Municipio 2, Municipio 3, Municipio 4, Municipio 5,');

insert into represa values(null, 'Represa 1', 100, 25, 1);
insert into represa values(null, 'Represa 2', 200, 50, 1);
insert into represa values(null, 'Represa 3', 300, 75, 1);
insert into represa values(null, 'Represa 4', 400, 100, 2);
insert into represa values(null, 'Represa 5', 500, 125, 2);
insert into represa values(null, 'Represa 6', 600, 150, 2);
insert into represa values(null, 'Represa 7', 700, 175, 3);
insert into represa values(null, 'Represa 8', 800, 200, 3);
insert into represa values(null, 'Represa 9', 900, 225, 3);

select * from represa where id_abastecimento = 1;

select * from abastecimento;

-- drop database SisAbastecimento;