/*
--------------------------------------------------------------------
--------------------------------------------------------------------
--------------------------------------------------------------------
----------------Medico----------------------------------------------
--------------------------------------------------------------------
--------------------------------------------------------------------
--------------------------------------------------------------------
--------------------------------------------------------------------

*/


/*

Procedure  Listado de Medicos
*/

drop procedure if exists sp_consultar_Medico;

delimiter &&
create procedure sp_consultar_Medico()
begin
select * from medico;
end&&
delimiter ;


call sp_consultar_Medico;


/*

Procedure  Listado de MedicosxCMP
*/

drop procedure if exists sp_consultar_MedicoxCMP;

delimiter &&
create procedure sp_consultar_MedicoxCMP(codigo varchar(50))
begin
SET @consulta = CONCAT('select * from medico where idmedico like ''%', codigo,'%''');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
end&&
delimiter ;


call sp_consultar_MedicoxCMP(77);


/*

Procedure  obtencion de Medico por Nombre y/o apellido
*/

drop procedure if exists sp_consultar_Medicoxnombreoapellido;

delimiter &&
create procedure sp_consultar_Medicoxnombreoapellido(nombre varchar(50),apellido varchar(50))
begin
SET @consulta = CONCAT('select * from medico where med_nombres like ''%', nombre,'%'' and med_apellidos like ''%', apellido,'%''');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
end&&
delimiter ;


call sp_consultar_Medicoxnombreoapellido('','v');

/*
--------------------------------------------------------------------
--------------------------------------------------------------------
--------------------------------------------------------------------
---------------------Centro Medico----------------------------------
--------------------------------------------------------------------
--------------------------------------------------------------------
--------------------------------------------------------------------
--------------------------------------------------------------------

*/




/*

Procedure  Listado de Centros_Medicos
*/

drop procedure if exists sp_consultar_Centros_Medicos;

delimiter &&
create procedure sp_consultar_Centros_Medicos()
begin
select * from centro_medico;
end&&
delimiter ;


call sp_consultar_Centros_Medicos;


/*

Procedure  Listado de Centros_MedicosxRUC
*/

drop procedure if exists sp_consultar_Centros_MedicosxRUC;

delimiter &&
create procedure sp_consultar_Centros_MedicosxRUC(ruc varchar(11))
begin
SET @consulta = CONCAT('select * from centro_medico where cem_ruc like ''%', ruc,'%''');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
end&&
delimiter ;


call sp_consultar_Centros_MedicosxRUC('');



/*

Procedure  obtencion de Centros_MedicosxRazonSocial
*/

drop procedure if exists sp_consultar_Centros_MedicosxRazonSocial;

delimiter &&
create procedure sp_consultar_Centros_MedicosxRazonSocial(razonsocial varchar(11))
begin
SET @consulta = CONCAT('select * from centro_medico where cem_razonsocial like ''%', razonsocial,'%''');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
end&&
delimiter ;


call sp_consultar_Centros_MedicosxRazonSocial('');



/*

Procedure  Listado de Correos
*/

drop procedure if exists sp_consultar_Correos;

delimiter &&
create procedure sp_consultar_Correos()
begin
select * from correo;
end&&
delimiter ;


call sp_consultar_Correos;


