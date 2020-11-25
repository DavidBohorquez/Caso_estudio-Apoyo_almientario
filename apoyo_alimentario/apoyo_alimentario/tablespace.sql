
begin
	EXECUTE IMMEDIATE 'drop tablespace APOYOALIMENTARIODEF including contents and datafiles';
	EXCEPTION WHEN OTHERS THEN NULL;
end;
/


begin
	EXECUTE IMMEDIATE 'drop tablespace APOYOALIMENTARIOTMP including contents and datafiles';
	EXCEPTION WHEN OTHERS THEN NULL;
end;
/

begin
	EXECUTE IMMEDIATE 'drop user APOYO_ALIMENTARIO_USR';
	EXCEPTION WHEN OTHERS THEN NULL;
end;
/

create tablespace APOYOALIMENTARIODEF DATAFILE 'C:\orclDB\oradata\orclDB\APOYOALIMENTARIODEF.DBF' SIZE 2M AUTOEXTEND ON;

create TEMPORARY tablespace APOYOALIMENTARIOTMP TEMPFILE 'C:\orclDB\oradata\orclDB\APOYOALIMENTARIOTMP.DBF' SIZE 2M AUTOEXTEND ON;

create user APOYO_ALIMENTARIO_USR IDENTIFIED BY APOYO123
  DEFAULT TABLESPACE APOYOALIMENTARIODEF
  TEMPORARY TABLESPACE APOYOALIMENTARIOTMP
  QUOTA 2M ON APOYOALIMENTARIODEF;

GRANT CONNECT, RESOURCE TO APOYO_ALIMENTARIO_USR;