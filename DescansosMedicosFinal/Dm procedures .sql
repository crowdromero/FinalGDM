/*
		SP NUevo Descanso Medico

*/

drop procedure if exists sp_nuevo_descanso_medico;

delimiter &&
create procedure sp_nuevo_descanso_medico(in iddm int,in idempleado VARCHAR(6),in fechainicio date,in fechafin date,in tipolicencia int,in diagnostico int,in medico varchar(8),in cmedico int,in observaciones varchar(75),in cantdias int)
begin
INSERT INTO descansomedico(iddescansomedico,dm_idempleado,dm_fechaincio,dm_fechafin,dm_tipolicencia,dm_diagnostico,dm_medico,dm_centromedico,dm_observaciones,dm_cant_dias) 
VALUES (iddm, idempleado, fechainicio,fechafin,tipolicencia,diagnostico,medico,cmedico,observaciones,cantdias);
end&&
delimiter ;

select * from descansomedico;

call sp_nuevo_descanso_medico(1000001,'E00001','2017/12/20','2017/12/25',1,1,'07777',1,'Nada interesante que contar',5);
call sp_nuevo_descanso_medico(1000002,'E00001','2017/12/20','2017/12/25',1,1,'07777',1,'Nada interesante que contar',5);
call sp_nuevo_descanso_medico(1000003,'E00001','2017/12/20','2017/12/25',1,1,'07777',1,'Nada interesante que conta',5);
call sp_nuevo_descanso_medico(1000004,'E00001','2017/12/20','2017/12/25',1,1,'07777',1,'Nada interesante que contar',5);
call sp_nuevo_descanso_medico(1000005,'E00001','2017/12/20','2017/12/25',1,1,'07777',1,'Nada interesante que contar',5);
call sp_nuevo_descanso_medico(1000006,'E00001','2017/12/20','2017/12/25',1,1,'07777',1,'Nada interesante que contar',5);


/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	sp_consultar_descanso_medico_porfecha
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/


drop procedure if exists sp_consultar_descanso_medico_porfecha;

delimiter &&
create procedure sp_consultar_descanso_medico_porfecha(in fechainicio varchar(10),in fechafin varchar(10))
begin

    select dm.iddescansomedico,e.idempleado,e.emp_nombre,e.emp_apellido,dm.dm_fechaincio,dm.dm_fechafin,tl.des_tip_licencia,diag.diag_descripcion,med.idmedico,concat(med.med_nombres,' ',med.med_apellidos) as Medico,cm.cem_ruc,cm.cem_razonsocial,dm.dm_observaciones,dm.dm_cant_dias
	from descansomedico as dm
	inner join empleado as e
	on dm.dm_idempleado=e.idempleado
	inner join diagnostico as diag
	on dm.dm_diagnostico=diag.iddiagnostico
	inner join centro_medico as cm
	on dm.dm_centromedico=cm.idcentro_medico
	inner join medico as med
	on dm.dm_medico=med.idmedico
	inner join tipo_licencia tl
	on dm.dm_tipolicencia=tl.idTipo_licencia
	where dm.dm_fechaincio>=fechainicio 
	and dm.dm_fechafin<=fechafin;
	
end&&
delimiter ;

call sp_consultar_descanso_medico_porfecha('2017/01/29','2018/01/01');

/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	sp_consultar_descanso_medicoxEmpleado
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

drop procedure if exists sp_consultar_descanso_medicoxEmpleado;

delimiter &&
create procedure sp_consultar_descanso_medicoxEmpleado(in codigo varchar(6))
begin

    select dm.iddescansomedico,e.idempleado,e.emp_nombre,e.emp_apellido,dm.dm_fechaincio,dm.dm_fechafin,tl.des_tip_licencia,diag.diag_descripcion,med.idmedico,concat(med.med_nombres,' ',med.med_apellidos) as Medico,cm.cem_ruc,cm.cem_razonsocial,dm.dm_observaciones,dm.dm_cant_dias
	from descansomedico as dm
	inner join empleado as e
	on dm.dm_idempleado=e.idempleado
	inner join diagnostico as diag
	on dm.dm_diagnostico=diag.iddiagnostico
	inner join centro_medico as cm
	on dm.dm_centromedico=cm.idcentro_medico
	inner join medico as med
	on dm.dm_medico=med.idmedico
	inner join tipo_licencia tl
	on dm.dm_tipolicencia=tl.idTipo_licencia
	where dm.dm_idempleado like CONCAT ('%', codigo, '%');
	
end&&
delimiter ;

call sp_consultar_descanso_medicoxEmpleado('e01');


/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	sp_consultar_descanso_medicoxMotivo
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/


drop procedure if exists sp_consultar_descanso_medicoxMotivo;

delimiter &&
create procedure sp_consultar_descanso_medicoxMotivo(in codigo int,in diagnostico int)
begin

    select dm.iddescansomedico,e.idempleado,e.emp_nombre,e.emp_apellido,dm.dm_fechaincio,dm.dm_fechafin,tl.des_tip_licencia,diag.diag_descripcion,med.idmedico,concat(med.med_nombres,' ',med.med_apellidos) as Medico,cm.cem_ruc,cm.cem_razonsocial,dm.dm_observaciones,dm.dm_cant_dias
	from descansomedico as dm
	inner join empleado as e
	on dm.dm_idempleado=e.idempleado
	inner join diagnostico as diag
	on dm.dm_diagnostico=diag.iddiagnostico
	inner join centro_medico as cm
	on dm.dm_centromedico=cm.idcentro_medico
	inner join medico as med
	on dm.dm_medico=med.idmedico
	inner join tipo_licencia tl
	on dm.dm_tipolicencia=tl.idTipo_licencia
	where dm.dm_tipolicencia=codigo and dm.dm_diagnostico=diagnostico ;
	
end&&
delimiter ;

call sp_consultar_descanso_medicoxMotivo(1,2);



/*
	
    Consulta de Descansos Medicos totales por persona (suma de dias)
    
*/

drop procedure if exists sp_consultar_descanso_medico_diastotalesxpersona;

delimiter &&
create procedure sp_consultar_descanso_medico_diastotalesxpersona(in codigo Varchar(6))
begin

select e.idempleado,e.emp_nombre,e.emp_apellido,sum(dm.dm_cant_dias)
from descansomedico as dm
inner join empleado as e
on dm.dm_idempleado=e.idempleado
inner join diagnostico as diag
on dm.dm_diagnostico=diag.iddiagnostico
inner join centro_medico as cm
on dm.dm_centromedico=cm.idcentro_medico
inner join medico as med
on dm.dm_medico=med.idmedico
inner join tipo_licencia tl
on dm.dm_tipolicencia=tl.idTipo_licencia
group by e.idempleado
having e.idempleado like CONCAT ('%', codigo, '%');
end&&
delimiter ;

call sp_consultar_descanso_medico_diastotalesxpersona('e');

/*


Consultar Todos los descansos

*/

drop procedure if exists sp_consultar_descanso_medico;

delimiter &&
create procedure sp_consultar_descanso_medico()
begin

select dm.iddescansomedico,e.idempleado,e.emp_nombre,e.emp_apellido,dm.dm_fechaincio,dm_fechafin,tl.des_tip_licencia,diag.diag_descripcion,med.idmedico,concat(med.med_nombres,' ',med.med_apellidos) as Medico,cm.cem_ruc,cm.cem_razonsocial,dm.dm_observaciones,dm.dm_cant_dias
from descansomedico as dm
inner join empleado as e
on dm.dm_idempleado=e.idempleado
inner join diagnostico as diag
on dm.dm_diagnostico=diag.iddiagnostico
inner join centro_medico as cm
on dm.dm_centromedico=cm.idcentro_medico
inner join medico as med
on dm.dm_medico=med.idmedico
inner join tipo_licencia tl
on dm.dm_tipolicencia=tl.idTipo_licencia;


end&&
delimiter ;

call sp_consultar_descanso_medico();


/*sp_consultar_descanso_medico_porfecha
