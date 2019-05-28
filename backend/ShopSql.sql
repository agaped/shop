-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema shop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shop` DEFAULT CHARACTER SET utf8 ;
USE `shop` ;

-- -----------------------------------------------------
-- Table `shop`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`category` (
  `id_category` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `shop`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`user` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `shop`.`img`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`img` (
  `id_img` INT(11) NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_img`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `shop`.`promotion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`promotion` (
  `id_promotion` INT(11) NOT NULL AUTO_INCREMENT,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_promotion`),
  UNIQUE INDEX `start_date_UNIQUE` (`start_date` ASC),
  UNIQUE INDEX `end_date_UNIQUE` (`end_date` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `shop`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`product` (
  `id_product` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `producer` VARCHAR(50) NOT NULL,
  `price` DECIMAL(6,2) NOT NULL,
  `price_promotion` DECIMAL(6,2) NULL DEFAULT NULL,
  `description` VARCHAR(600) NOT NULL,
  `promotion_id_promotion` INT(11) NULL DEFAULT NULL,
  `img_id_img` INT(11) NULL DEFAULT NULL,
  `category_id_category` INT(11) NOT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `fk_Product_Promotion_idx` (`promotion_id_promotion` ASC),
  INDEX `fk_Product_Img1_idx` (`img_id_img` ASC),
  INDEX `fk_Product_Categry1_idx` (`category_id_category` ASC),
  CONSTRAINT `fk_Product_Categry1`
    FOREIGN KEY (`category_id_category`)
    REFERENCES `shop`.`category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_Img1`
    FOREIGN KEY (`img_id_img`)
    REFERENCES `shop`.`img` (`id_img`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_Promotion`
    FOREIGN KEY (`promotion_id_promotion`)
    REFERENCES `shop`.`promotion` (`id_promotion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `shop`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`comment` (
  `id_comment` INT(11) NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(300) NOT NULL,
  `product_id_product` INT(11) NOT NULL,
  `user_id_user` INT(11) NOT NULL,
  PRIMARY KEY (`id_comment`, `product_id_product`, `user_id_user`),
  INDEX `fk_Product_has_Client_Client1_idx` (`user_id_user` ASC),
  INDEX `fk_Product_has_Client_Product1_idx` (`product_id_product` ASC),
  CONSTRAINT `fk_Product_has_Client_Client1`
    FOREIGN KEY (`user_id_user`)
    REFERENCES `shop`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_Client_Product1`
    FOREIGN KEY (`product_id_product`)
    REFERENCES `shop`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `shop`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`order` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `payment` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `delivery` VARCHAR(45) NOT NULL,
  `total` DECIMAL(6,2) NOT NULL,
  `user_id_user` INT(11) NOT NULL,
  PRIMARY KEY (`id_order`, `user_id_user`),
  INDEX `fk_Order_Client1_idx` (`user_id_user` ASC),
  CONSTRAINT `fk_Order_Client1`
    FOREIGN KEY (`user_id_user`)
    REFERENCES `shop`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `shop`.`ordered_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shop`.`ordered_products` (
  `ordered_products` INT(11) NOT NULL AUTO_INCREMENT,
  `amount` INT(11) NOT NULL,
  `product_id_product` INT(11) NOT NULL,
  `order_id_order` INT(11) NOT NULL,
  PRIMARY KEY (`ordered_products`, `order_id_order`, `product_id_product`),
  INDEX `fk_Product_has_Order_Order1_idx` (`order_id_order` ASC),
  INDEX `fk_Product_has_Order_Product1_idx` (`product_id_product` ASC),
  CONSTRAINT `fk_Product_has_Order_Order1`
    FOREIGN KEY (`order_id_order`)
    REFERENCES `shop`.`order` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_Order_Product1`
    FOREIGN KEY (`product_id_product`)
    REFERENCES `shop`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
