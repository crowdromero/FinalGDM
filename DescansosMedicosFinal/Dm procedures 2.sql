/*

Procedure  Listado de combo de licencias
*/

drop procedure if exists sp_consultar_licencias;

delimiter &&
create procedure sp_consultar_licencias()
begin
select * from tipo_licencia where tipli_estado>0;
end&&
delimiter ;


call sp_consultar_licencias;

select * from tipo_licencia where tipli_estado>0;


/*

Procedure  obtencion de Empleados
*/

drop procedure if exists sp_consultar_Empleados;

delimiter &&
create procedure sp_consultar_Empleados()
begin
select * from empleado;
end&&
delimiter ;


call sp_consultar_Empleados;

select * from empleado;

/*

Procedure  obtencion de Empleado por Nombre
*/

drop procedure if exists sp_consultar_EmpleadosxDatos;

delimiter &&
create procedure sp_consultar_EmpleadosxDatos(nombre varchar(50),apellido varchar(50))
begin
SET @consulta = CONCAT('select * from empleado where emp_nombre like ''%', nombre,'%'' and emp_apellido like ''%', apellido,'%''');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
end&&
delimiter ;


call sp_consultar_EmpleadosxDatos('da','');


/*

Procedure  obtencion de Empleado por codigo
*/

drop procedure if exists sp_consultar_EmpleadosxCodigo;

delimiter &&
create procedure sp_consultar_EmpleadosxCodigo(codigo varchar(50))
begin
SET @consulta = CONCAT('select * from empleado where idempleado like ''%', codigo,'%''');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
end&&
delimiter ;

call sp_consultar_EmpleadosxCodigo('01');


/*

Procedure  Listado de combo de licencias
*/

drop procedure if exists sp_consultar_diagnostico;

delimiter &&
create procedure sp_consultar_diagnostico()
begin
select * from diagnostico;
end&&
delimiter ;


call sp_consultar_diagnostico;

select * from diagnostico where diag_estado>0;

/*

Procedure  Listado de combo de licencias
*/

drop procedure if exists sp_consultar_diagnosticoxcodigo;

delimiter &&
create procedure sp_consultar_diagnosticoxcodigo(codigo varchar(50))
begin
SET @consulta = CONCAT('select * from diagnostico where iddiagnostico like ''%', codigo,'%''');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
end&&
delimiter ;

/*

Procedure  Listado de combo de licencias
*/

drop procedure if exists sp_consultar_diagnosticoxDescripcion;

delimiter &&
create procedure sp_consultar_diagnosticoxDescripcion(descripcion varchar(50))
begin
SET @consulta = CONCAT('select * from diagnostico where diag_descripcion like ''%', descripcion,'%''');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
end&&
delimiter ;