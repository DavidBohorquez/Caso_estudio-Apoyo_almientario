drop tablespace APOYOALIMENTARIODEF including contents and datafiles;
drop tablespace APOYOALIMENTARIOTMP including contents and datafiles;
drop user APOYO_ALIMENTARIO_USR;

DROP ROLE R_CONSULTA;
DROP ROLE R_ESTUDIANTE;
DROP ROLE R_COORDINADOR;
DROP ROLE R_FUNCIONARIO;
DROP ROLE R_BENEFICIARIO;
DROP ROLE R_APP;
DROP ROLE R_ADMIN;

commit;

--create tablespace
create tablespace APOYOALIMENTARIODEF DATAFILE 'C:\orclDB\oradata\orclDB\APOYOALIMENTARIODEF.DBF' SIZE 2M AUTOEXTEND ON;

create TEMPORARY tablespace APOYOALIMENTARIOTMP TEMPFILE 'C:\orclDB\oradata\orclDB\APOYOALIMENTARIOTMP.DBF' SIZE 2M AUTOEXTEND ON;

--create user
create user APOYO_ALIMENTARIO_USR IDENTIFIED BY APOYO123
  DEFAULT TABLESPACE APOYOALIMENTARIODEF
  TEMPORARY TABLESPACE APOYOALIMENTARIOTMP
  QUOTA 2M ON APOYOALIMENTARIODEF;

GRANT CONNECT, RESOURCE TO APOYO_ALIMENTARIO_USR WITH ADMIN OPTION;
GRANT CREATE PUBLIC SYNONYM, CREATE ANY VIEW TO APOYO_ALIMENTARIO_USR;

--create roles

CREATE ROLE R_CONSULTA;
CREATE ROLE R_ESTUDIANTE;
CREATE ROLE R_COORDINADOR;
CREATE ROLE R_FUNCIONARIO;
CREATE ROLE R_BENEFICIARIO;
CREATE ROLE R_APP;
CREATE ROLE R_ADMIN;


commit;