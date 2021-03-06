-- MySQL Script generated by MySQL Workbench
-- Thu Dec 21 03:25:24 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema BD_DM
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `BD_DM` ;

-- -----------------------------------------------------
-- Schema BD_DM
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BD_DM` DEFAULT CHARACTER SET utf8 ;
USE `BD_DM` ;

-- -----------------------------------------------------
-- Table `BD_DM`.`DEPARTAMENTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`DEPARTAMENTO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`DEPARTAMENTO` (
  `iddepartamento` INT NOT NULL,
  `dep_descripcion` VARCHAR(15) NOT NULL,
  `dep_estado` INT NOT NULL,
  `dep_abreviatura` VARCHAR(5) NULL,
  PRIMARY KEY (`iddepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`PROVINCIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`PROVINCIA` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`PROVINCIA` (
  `idprovincia` INT NOT NULL,
  `prov_descripcion` VARCHAR(25) NOT NULL,
  `prov_estado` INT NOT NULL,
  `iddepartamento` INT NOT NULL,
  `prov_abreviatura` VARCHAR(5) NULL,
  PRIMARY KEY (`idprovincia`),
  INDEX `iddepartamento_idx` (`iddepartamento` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`TIPO_DOCUMENTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`TIPO_DOCUMENTO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`TIPO_DOCUMENTO` (
  `idtdoc` INT NOT NULL,
  `tdoc_descripcion` VARCHAR(50) NOT NULL,
  `tdoc_estado` INT NOT NULL,
  `tdoc_abreviatura` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`idtdoc`),
  UNIQUE INDEX `idtdoc_UNIQUE` (`idtdoc` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`DIAGNOSTICO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`DIAGNOSTICO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`DIAGNOSTICO` (
  `iddiagnostico` INT NOT NULL,
  `diag_descripcion` VARCHAR(30) NOT NULL,
  `diag_estado` INT NOT NULL,
  PRIMARY KEY (`iddiagnostico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`MEDICO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`MEDICO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`MEDICO` (
  `idmedico` VARCHAR(8) NOT NULL,
  `med_nombres` VARCHAR(15) NOT NULL,
  `med_apellidos` VARCHAR(20) NOT NULL,
  `med_activo` INT NOT NULL,
  PRIMARY KEY (`idmedico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`DISTRITO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`DISTRITO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`DISTRITO` (
  `iddistrito` INT NOT NULL,
  `dist_descripcion` VARCHAR(50) NOT NULL,
  `dist_estado` INT NOT NULL,
  `idprovincia` INT NOT NULL,
  `dist_abreviatura` VARCHAR(5) NULL,
  PRIMARY KEY (`iddistrito`),
  INDEX `idprovincia_idx` (`idprovincia` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`CENTRO_MEDICO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`CENTRO_MEDICO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`CENTRO_MEDICO` (
  `idcentro_medico` INT NOT NULL,
  `cem_ruc` VARCHAR(11) NOT NULL,
  `cem_razonsocial` VARCHAR(50) NOT NULL,
  `cem_direccion` VARCHAR(100) NOT NULL,
  `iddepartamento` INT NOT NULL,
  `idprovincia` INT NOT NULL,
  `iddistrito` INT NOT NULL,
  `cem_estado` INT NOT NULL,
  PRIMARY KEY (`idcentro_medico`),
  INDEX `iddepartamento_idx` (`iddepartamento` ASC),
  INDEX `idprovincia_idx` (`idprovincia` ASC),
  INDEX `iddistrito_idx` (`iddistrito` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`UNIDAD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`UNIDAD` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`UNIDAD` (
  `idunidad` INT NOT NULL,
  `uni_descripcion` VARCHAR(30) NOT NULL,
  `uni_ruc` VARCHAR(11) NULL,
  PRIMARY KEY (`idunidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`PERFIL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`PERFIL` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`PERFIL` (
  `idperfil` INT NOT NULL,
  `perf_descripcion` VARCHAR(15) NOT NULL,
  `perf_estado` INT NOT NULL,
  PRIMARY KEY (`idperfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`ESTADO_CIVIL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`ESTADO_CIVIL` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`ESTADO_CIVIL` (
  `idestcivil` INT NOT NULL,
  `est_descripcion` VARCHAR(15) NOT NULL,
  `est_abreviatura` CHAR(1) NOT NULL,
  `est_estado` INT NOT NULL,
  PRIMARY KEY (`idestcivil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`GERENCIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`GERENCIA` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`GERENCIA` (
  `idgerencia` INT NOT NULL,
  `ger_descripcion` VARCHAR(30) NOT NULL,
  `ger_estado` INT NOT NULL,
  PRIMARY KEY (`idgerencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`TIPO_DE_TRABAJADOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`TIPO_DE_TRABAJADOR` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`TIPO_DE_TRABAJADOR` (
  `id_tipo_trabajador` INT NOT NULL,
  `titrab_descripcion` VARCHAR(20) NOT NULL,
  `titrab_estado` INT NOT NULL,
  PRIMARY KEY (`id_tipo_trabajador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`PUESTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`PUESTO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`PUESTO` (
  `idpuesto` INT NOT NULL,
  `pu_descripcion` VARCHAR(45) NOT NULL,
  `pu_estado` INT NOT NULL,
  PRIMARY KEY (`idpuesto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`EMPLEADO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`EMPLEADO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`EMPLEADO` (
  `idempleado` VARCHAR(6) NOT NULL,
  `emp_nombre` VARCHAR(20) NOT NULL,
  `emp_apellido` VARCHAR(30) NOT NULL,
  `emp_tipo_documento` INT NOT NULL,
  `emp_numero_doc` VARCHAR(8) NOT NULL,
  `emp_fecha_naciemiento` DATE NOT NULL,
  `emp_estado_civil` INT NOT NULL,
  `emp_telefono` VARCHAR(15) NOT NULL,
  `emp_direccion` VARCHAR(70) NOT NULL,
  `emp_correo` VARCHAR(45) NOT NULL,
  `emp_genero` CHAR(1) NOT NULL,
  `emp_estado` INT NOT NULL,
  `emp_idtipotrabajador` INT NOT NULL,
  `emp_idpuesto` INT NOT NULL,
  `emp_idgerencia` INT NOT NULL,
  `emp_idunidad` INT NOT NULL,
  `emp_iddepartamento` INT NOT NULL,
  `emp_idprovincia` INT NOT NULL,
  `emp_iddistrito` INT NOT NULL,
  PRIMARY KEY (`idempleado`),
  INDEX `emp_tipo_documento_idx` (`emp_tipo_documento` ASC),
  INDEX `emp_estado_civil_idx` (`emp_estado_civil` ASC),
  INDEX `emp_idtipotrabajador_idx` (`emp_idtipotrabajador` ASC),
  INDEX `emp_idpuesto_idx` (`emp_idpuesto` ASC),
  INDEX `emp_idgerencia_idx` (`emp_idgerencia` ASC),
  INDEX `emp_idunidad_idx` (`emp_idunidad` ASC),
  INDEX `emp_iddepartamento_idx` (`emp_iddepartamento` ASC),
  INDEX `emp_idprovincia_idx` (`emp_idprovincia` ASC),
  INDEX `emp_iddistrito_idx` (`emp_iddistrito` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`TIPO_LICENCIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`TIPO_LICENCIA` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`TIPO_LICENCIA` (
  `idTipo_licencia` INT NOT NULL,
  `des_tip_licencia` VARCHAR(15) NOT NULL,
  `tipli_estado` INT NOT NULL,
  PRIMARY KEY (`idTipo_licencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`DESCANSOMEDICO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`DESCANSOMEDICO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`DESCANSOMEDICO` (
  `iddescansomedico` INT NOT NULL,
  `dm_idempleado` VARCHAR(6) NOT NULL,
  `dm_fechaincio` DATE NOT NULL,
  `dm_fechafin` DATE NOT NULL,
  `dm_tipolicencia` INT NOT NULL,
  `dm_diagnostico` INT NOT NULL,
  `dm_medico` VARCHAR(8) NULL,
  `dm_centromedico` INT NULL,
  `dm_observaciones` VARCHAR(75) NOT NULL,
  `dm_cant_dias` INT NOT NULL,
  PRIMARY KEY (`iddescansomedico`),
  INDEX `dm_diagnostico_idx` (`dm_diagnostico` ASC),
  INDEX `dm_medico_idx` (`dm_medico` ASC),
  INDEX `dm_centromedico_idx` (`dm_centromedico` ASC),
  INDEX `dm_idempleado_idx` (`dm_idempleado` ASC),
  INDEX `dm_tipolicencia_idx` (`dm_tipolicencia` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_DM`.`USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`USUARIO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`USUARIO` (
  `idusuario` INT NOT NULL,
  `usu_codigo` VARCHAR(10) NOT NULL,
  `usu_contraseña` VARCHAR(10) NOT NULL,
  `usu_estado` INT NOT NULL,
  `usu_idempleado` VARCHAR(6) NOT NULL,
  `usu_perfil` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `usu_idempleado_idx` (`usu_idempleado` ASC),
  INDEX `usu_perfil_idx` (`usu_perfil` ASC))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `BD_DM`.`CORREO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BD_DM`.`CORREO` ;

CREATE TABLE IF NOT EXISTS `BD_DM`.`CORREO` (
  `idregcorreo` INT NOT NULL,
  `correo_dias` INT NOT NULL,
  `correo_des` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idregcorreo`));



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `BD_DM`.`DEPARTAMENTO`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`DEPARTAMENTO` (`iddepartamento`, `dep_descripcion`, `dep_estado`, `dep_abreviatura`) VALUES (1, 'Amazonas', 1, NULL);
INSERT INTO `BD_DM`.`DEPARTAMENTO` (`iddepartamento`, `dep_descripcion`, `dep_estado`, `dep_abreviatura`) VALUES (2, 'Ancash', 1, NULL);
INSERT INTO `BD_DM`.`DEPARTAMENTO` (`iddepartamento`, `dep_descripcion`, `dep_estado`, `dep_abreviatura`) VALUES (3, 'Lima', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`PROVINCIA`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`PROVINCIA` (`idprovincia`, `prov_descripcion`, `prov_estado`, `iddepartamento`, `prov_abreviatura`) VALUES (1, 'Lima', 1, 3, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`TIPO_DOCUMENTO`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`TIPO_DOCUMENTO` (`idtdoc`, `tdoc_descripcion`, `tdoc_estado`, `tdoc_abreviatura`) VALUES (1, 'Documento Nacional de Identidad', 1, 'DNI');
INSERT INTO `BD_DM`.`TIPO_DOCUMENTO` (`idtdoc`, `tdoc_descripcion`, `tdoc_estado`, `tdoc_abreviatura`) VALUES (2, 'Libreta Militar', 1, 'LM');
INSERT INTO `BD_DM`.`TIPO_DOCUMENTO` (`idtdoc`, `tdoc_descripcion`, `tdoc_estado`, `tdoc_abreviatura`) VALUES (3, 'Carnet de Extranjeria', 1, 'CE');
INSERT INTO `BD_DM`.`TIPO_DOCUMENTO` (`idtdoc`, `tdoc_descripcion`, `tdoc_estado`, `tdoc_abreviatura`) VALUES (4, 'Pasaporte', 1, 'PAS');

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`DIAGNOSTICO`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`DIAGNOSTICO` (`iddiagnostico`, `diag_descripcion`, `diag_estado`) VALUES (1, 'Fractura', 1);
INSERT INTO `BD_DM`.`DIAGNOSTICO` (`iddiagnostico`, `diag_descripcion`, `diag_estado`) VALUES (2, 'Diarrea', 1);
INSERT INTO `BD_DM`.`DIAGNOSTICO` (`iddiagnostico`, `diag_descripcion`, `diag_estado`) VALUES (3, 'Colicos', 1);
INSERT INTO `BD_DM`.`DIAGNOSTICO` (`iddiagnostico`, `diag_descripcion`, `diag_estado`) VALUES (4, 'Migraña', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`DISTRITO`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`DISTRITO` (`iddistrito`, `dist_descripcion`, `dist_estado`, `idprovincia`, `dist_abreviatura`) VALUES (1, 'San Juan de Lurigancho', 1, 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`UNIDAD`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`UNIDAD` (`idunidad`, `uni_descripcion`, `uni_ruc`) VALUES (1, 'UTP', '20462509236');
INSERT INTO `BD_DM`.`UNIDAD` (`idunidad`, `uni_descripcion`, `uni_ruc`) VALUES (2, 'IDAT', '20109199835');

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`PERFIL`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`PERFIL` (`idperfil`, `perf_descripcion`, `perf_estado`) VALUES (1, 'Administrador', 1);
INSERT INTO `BD_DM`.`PERFIL` (`idperfil`, `perf_descripcion`, `perf_estado`) VALUES (2, 'Jefe de Area', 1);
INSERT INTO `BD_DM`.`PERFIL` (`idperfil`, `perf_descripcion`, `perf_estado`) VALUES (3, 'Usuario Normal', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`ESTADO_CIVIL`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`ESTADO_CIVIL` (`idestcivil`, `est_descripcion`, `est_abreviatura`, `est_estado`) VALUES (1, 'Soltero', 'S', 1);
INSERT INTO `BD_DM`.`ESTADO_CIVIL` (`idestcivil`, `est_descripcion`, `est_abreviatura`, `est_estado`) VALUES (2, 'Casado', 'C', 1);
INSERT INTO `BD_DM`.`ESTADO_CIVIL` (`idestcivil`, `est_descripcion`, `est_abreviatura`, `est_estado`) VALUES (3, 'Viudo', 'V', 1);
INSERT INTO `BD_DM`.`ESTADO_CIVIL` (`idestcivil`, `est_descripcion`, `est_abreviatura`, `est_estado`) VALUES (4, 'Divorciado', 'D', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`GERENCIA`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`GERENCIA` (`idgerencia`, `ger_descripcion`, `ger_estado`) VALUES (1, 'Direccion General', 1);
INSERT INTO `BD_DM`.`GERENCIA` (`idgerencia`, `ger_descripcion`, `ger_estado`) VALUES (2, 'Recursos Humanos', 1);
INSERT INTO `BD_DM`.`GERENCIA` (`idgerencia`, `ger_descripcion`, `ger_estado`) VALUES (3, 'Admision', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`TIPO_DE_TRABAJADOR`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`TIPO_DE_TRABAJADOR` (`id_tipo_trabajador`, `titrab_descripcion`, `titrab_estado`) VALUES (1, 'Administrativo', 1);
INSERT INTO `BD_DM`.`TIPO_DE_TRABAJADOR` (`id_tipo_trabajador`, `titrab_descripcion`, `titrab_estado`) VALUES (2, 'Docente', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`PUESTO`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`PUESTO` (`idpuesto`, `pu_descripcion`, `pu_estado`) VALUES (1, 'Asistente de Laboratorio', 1);
INSERT INTO `BD_DM`.`PUESTO` (`idpuesto`, `pu_descripcion`, `pu_estado`) VALUES (2, 'Coordinador', 1);
INSERT INTO `BD_DM`.`PUESTO` (`idpuesto`, `pu_descripcion`, `pu_estado`) VALUES (3, 'Asistente de Vda Universitaria', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`EMPLEADO`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`EMPLEADO` (`idempleado`, `emp_nombre`, `emp_apellido`, `emp_tipo_documento`, `emp_numero_doc`, `emp_fecha_naciemiento`, `emp_estado_civil`, `emp_telefono`, `emp_direccion`, `emp_correo`, `emp_genero`, `emp_estado`, `emp_idtipotrabajador`, `emp_idpuesto`, `emp_idgerencia`, `emp_idunidad`, `emp_iddepartamento`, `emp_idprovincia`, `emp_iddistrito`) VALUES ('E00001', 'Daniel', 'Romero', 1, '72696054', '1992/10/29', 1, '934431081', 'jr Jose de San Martin 624 Urb San Rafael', 'dromero@gmail.com', 'M', 1, 1, 1, 1, 1, 3, 1, 1);
INSERT INTO `BD_DM`.`EMPLEADO` (`idempleado`, `emp_nombre`, `emp_apellido`, `emp_tipo_documento`, `emp_numero_doc`, `emp_fecha_naciemiento`, `emp_estado_civil`, `emp_telefono`, `emp_direccion`, `emp_correo`, `emp_genero`, `emp_estado`, `emp_idtipotrabajador`, `emp_idpuesto`, `emp_idgerencia`, `emp_idunidad`, `emp_iddepartamento`, `emp_idprovincia`, `emp_iddistrito`) VALUES ('E00002', 'Juan', 'Rodriguez', 1, '72696058', '1991/10/29', 1, '935594382', 'jr Jose de San Martin 624 Urb San Rafael', 'dromero@gmail.com', 'M', 1, 1, 1, 1, 1, 3, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `BD_DM`.`TIPO_LICENCIA`
-- -----------------------------------------------------
START TRANSACTION;
USE `BD_DM`;
INSERT INTO `BD_DM`.`TIPO_LICENCIA` (`idTipo_licencia`, `des_tip_licencia`, `tipli_estado`) VALUES (1, 'Embarazo', 1);
INSERT INTO `BD_DM`.`TIPO_LICENCIA` (`idTipo_licencia`, `des_tip_licencia`, `tipli_estado`) VALUES (2, 'Accidente', 1);
INSERT INTO `BD_DM`.`TIPO_LICENCIA` (`idTipo_licencia`, `des_tip_licencia`, `tipli_estado`) VALUES (3, 'Enfermedad', 1);

COMMIT;

insert into medico values('07777','Jacinto','ventura',1);
insert into usuario values(1,'admin','123456',1,'E00001',1);
insert into centro_medico values (1,10726960548,'Hogar Comun','La Calle',3,1,1,1);

insert into correo values(1,300,'ntw.dromero@gmail.com');
insert into correo values(2,120,'daa.room@gmail.com');
insert into correo values(3,90,'ntw.dromero@gmail.com');
insert into correo values(4,20,'ntw.dromero@gmail.com');





 
 