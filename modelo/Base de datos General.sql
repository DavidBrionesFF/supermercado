SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `sistema` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;

CREATE TABLE IF NOT EXISTS `sistema`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `apellido` VARCHAR(255) NOT NULL,
  `contrasena` VARCHAR(255) NOT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `nombre_usuario` VARCHAR(255) NOT NULL,
  `perfil` VARCHAR(300) NULL DEFAULT 'img/perfil.jpg',
  `activo` TINYINT(1) NULL DEFAULT 1,
  `rol` INT(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `nombre_usuario_UNIQUE` (`nombre_usuario` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;

CREATE TABLE IF NOT EXISTS `sistema`.`producto` (
  `id_producto` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `precio` INT(11) NOT NULL,
  `descripcion` VARCHAR(300) NULL DEFAULT NULL,
  `poster` VARCHAR(500) NULL DEFAULT NULL,
  `id_categoria` INT(11) NOT NULL,
  `id_marca` INT(11) NOT NULL,
  `fecha_ingreso` DATE NULL DEFAULT NULL,
  `usuario_ingreso` INT(11) NOT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE INDEX `id_producto_UNIQUE` (`id_producto` ASC),
  INDEX `fk_producto_categoria_idx` (`id_categoria` ASC),
  INDEX `fk_producto_marca1_idx` (`id_marca` ASC),
  INDEX `fk_producto_usuario1_idx` (`usuario_ingreso` ASC),
  CONSTRAINT `fk_producto_categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `sistema`.`categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_marca1`
    FOREIGN KEY (`id_marca`)
    REFERENCES `sistema`.`marca` (`id_marca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_usuario1`
    FOREIGN KEY (`usuario_ingreso`)
    REFERENCES `sistema`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;

CREATE TABLE IF NOT EXISTS `sistema`.`marca` (
  `id_marca` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `descripcion` VARCHAR(300) NOT NULL,
  `fecha_integracion` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_marca`),
  UNIQUE INDEX `id_marca_UNIQUE` (`id_marca` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;

CREATE TABLE IF NOT EXISTS `sistema`.`categoria` (
  `id_categoria` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `descripcion` VARCHAR(500) NOT NULL DEFAULT 'Ejemplo de categoria',
  PRIMARY KEY (`id_categoria`),
  UNIQUE INDEX `id_categoria_UNIQUE` (`id_categoria` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;

CREATE TABLE IF NOT EXISTS `sistema`.`factura` (
  `id_factura` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_facturacion` DATE NOT NULL,
  `descripcion` VARCHAR(300) NULL DEFAULT 'Venta de productos domesticos',
  `usuario_id_facturacion` INT(11) NOT NULL,
  `subtotal` INT(11) NOT NULL,
  `total` INT(11) NOT NULL,
  PRIMARY KEY (`id_factura`),
  UNIQUE INDEX `id_factura_UNIQUE` (`id_factura` ASC),
  INDEX `fk_factura_usuario1_idx` (`usuario_id_facturacion` ASC),
  CONSTRAINT `fk_factura_usuario1`
    FOREIGN KEY (`usuario_id_facturacion`)
    REFERENCES `sistema`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;

CREATE TABLE IF NOT EXISTS `sistema`.`descripcion` (
  `id_descripcion` INT(11) NOT NULL AUTO_INCREMENT,
  `cantidad` INT(11) NOT NULL DEFAULT 1,
  `precio` INT(11) NULL DEFAULT NULL,
  `factura_id_factura` INT(11) NOT NULL,
  `producto_id_producto` INT(11) NOT NULL,
  PRIMARY KEY (`id_descripcion`),
  UNIQUE INDEX `id_descripcion_UNIQUE` (`id_descripcion` ASC),
  INDEX `fk_descripcion_factura1_idx` (`factura_id_factura` ASC),
  INDEX `fk_descripcion_producto1_idx` (`producto_id_producto` ASC),
  CONSTRAINT `fk_descripcion_factura1`
    FOREIGN KEY (`factura_id_factura`)
    REFERENCES `sistema`.`factura` (`id_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_descripcion_producto1`
    FOREIGN KEY (`producto_id_producto`)
    REFERENCES `sistema`.`producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci;

CREATE TABLE IF NOT EXISTS `sistema`.`ingresados` (
    `fecha_ingreso` DATE NOT NULL,
    `usuario_id` INT(11) NOT NULL,
    `tipo` TINYINT(1) NOT NULL,
    PRIMARY KEY (`fecha_ingreso`),
    INDEX `fk_ingresados_usuario1_idx` (`usuario_id` ASC),
    CONSTRAINT `fk_ingresados_usuario1` FOREIGN KEY (`usuario_id`)
        REFERENCES `sistema`.`usuario` (`id_usuario`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE = utf8_spanish2_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
