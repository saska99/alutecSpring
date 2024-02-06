-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema alutec
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema alutec
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `alutec` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `alutec` ;

-- -----------------------------------------------------
-- Table `alutec`.`ulazniartikal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alutec`.`ulazniartikal` (
  `sifra_artikla` VARCHAR(255) NOT NULL,
  `netopokom` DOUBLE NULL DEFAULT NULL,
  `cenapokom` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`sifra_artikla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `alutec`.`izlazniartikal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alutec`.`izlazniartikal` (
  `sifra_izlaznog_artikla` VARCHAR(255) NOT NULL,
  `sifra_ulaznog_artikla` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`sifra_izlaznog_artikla`),
  INDEX `izlazniartikal_ibfk_1` (`sifra_ulaznog_artikla` ASC) VISIBLE,
  CONSTRAINT `izlazniartikal_ibfk_1`
    FOREIGN KEY (`sifra_ulaznog_artikla`)
    REFERENCES `alutec`.`ulazniartikal` (`sifra_artikla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `alutec`.`izvozfaktura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alutec`.`izvozfaktura` (
  `broj_fakture` INT NOT NULL,
  `datum_izvoza` DATE NOT NULL,
  PRIMARY KEY (`broj_fakture`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `alutec`.`izvezeniartikli`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alutec`.`izvezeniartikli` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_izvoza` INT NOT NULL,
  `sifra_izlaznog_artikla` VARCHAR(255) NOT NULL,
  `neto` DOUBLE NULL DEFAULT NULL,
  `kom` INT NULL DEFAULT NULL,
  `ukupna_cena` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `izvezeniartikli_ibfk_1` (`id_izvoza` ASC) VISIBLE,
  INDEX `izvezeniartikli_ibfk_2` (`sifra_izlaznog_artikla` ASC) VISIBLE,
  CONSTRAINT `izvezeniartikli_ibfk_1`
    FOREIGN KEY (`id_izvoza`)
    REFERENCES `alutec`.`izvozfaktura` (`broj_fakture`),
  CONSTRAINT `izvezeniartikli_ibfk_2`
    FOREIGN KEY (`sifra_izlaznog_artikla`)
    REFERENCES `alutec`.`izlazniartikal` (`sifra_izlaznog_artikla`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `alutec`.`uvoz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alutec`.`uvoz` (
  `sifra_uvoza` VARCHAR(255) NOT NULL,
  `post` VARCHAR(255) NOT NULL,
  `zp` VARCHAR(255) NOT NULL,
  `datum_uvoza` DATE NOT NULL,
  PRIMARY KEY (`sifra_uvoza`),
  UNIQUE INDEX `sifra_uvoza_UNIQUE` (`sifra_uvoza` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `alutec`.`uvezeniartikli`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alutec`.`uvezeniartikli` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `id_uvoza` VARCHAR(255) NOT NULL,
  `sifra_artikla` VARCHAR(255) NOT NULL,
  `naim` INT NULL DEFAULT NULL,
  `neto` DOUBLE NULL DEFAULT NULL,
  `kom` INT NULL DEFAULT NULL,
  `ukupna_cena` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `uvezeniartikli_ibfk_1` (`id_uvoza` ASC) VISIBLE,
  INDEX `uvezeniartikli_ibfk_2` (`sifra_artikla` ASC) VISIBLE,
  CONSTRAINT `uvezeniartikli_ibfk_1`
    FOREIGN KEY (`id_uvoza`)
    REFERENCES `alutec`.`uvoz` (`sifra_uvoza`),
  CONSTRAINT `uvezeniartikli_ibfk_2`
    FOREIGN KEY (`sifra_artikla`)
    REFERENCES `alutec`.`ulazniartikal` (`sifra_artikla`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
