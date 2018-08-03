CREATE SCHEMA IF NOT EXISTS `login` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
	

-- -----------------------------------------------------
-- Table `login`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login`.`rol` (
  `idrol` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(45) NULL,
  `estado` TINYINT(1) NULL,
  PRIMARY KEY (`idrol`))
ENGINE = InnoDB;
insert into rol (nombre,descripcion,estado) values
('Administrador', 'Controlador del Sistema', true),
('Cliente', 'Usuario del Sistema', true);
select * from rol;
-- -----------------------------------------------------
-- Table `login`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login`.`persona` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NULL,
  `clave` VARCHAR(45) NULL,
  `rol_idrol` INT NOT NULL,
  PRIMARY KEY (`idpersona`),
  INDEX `fk_persona_rol_idx` (`rol_idrol` ASC),
  CONSTRAINT `fk_persona_rol`
    FOREIGN KEY (`rol_idrol`)
    REFERENCES `login`.`rol` (`idrol`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
insert into persona (nombres, apellidos, telefono, direccion, correo, clave, rol_idrol)
values ('Steven', 'Romero', '122345', 'Puente de Piedra', 'rsromero20@misena.edu.co', 'admin', 1),
('Matt', 'Tuck', '45678', 'Gales', 'matt@gmmail.com', 'user', 2);
select * from Persona;