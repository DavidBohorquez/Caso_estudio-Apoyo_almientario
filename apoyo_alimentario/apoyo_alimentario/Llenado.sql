
--Convocatoria
REM INSERTING into Convocatoria
INSERT into Convocatoria (K_ID_CONVOCATORIA, F_INICIO, F_RECEPCION_SOL, F_EVALUACION_SOL, F_CIERRE, I_ESTADO, Q_PERIODO, Q_ANIO) values (1, to_date('2021/03/01', 'YYYY/MM/DD'), to_date('2021/03/21', 'YYYY/MM/DD'), to_date('2021/03/22', 'YYYY/MM/DD'), to_date('2021/05/30', 'YYYY/MM/DD'), 'R', 1, 2021);
INSERT into Convocatoria (K_ID_CONVOCATORIA, F_INICIO, F_RECEPCION_SOL, F_EVALUACION_SOL, F_CIERRE, I_ESTADO, Q_PERIODO, Q_ANIO) values (2, to_date('2021/06/01', 'YYYY/MM/DD'), to_date('2021/06/21', 'YYYY/MM/DD'), to_date('2021/06/22', 'YYYY/MM/DD'), to_date('2021/08/30', 'YYYY/MM/DD'), 'E', 3, 2021);

--Coordinador
REM INSERTING into Coordinador
INSERT into Coordinador (K_TIPO_ID, K_ID, N_NOMBRES, N_APELLIDOS, N_CARGO) values ('CC', 1, 'Pepito', 'Perez', 'Cargo Prueba');
INSERT into Coordinador (K_TIPO_ID, K_ID, N_NOMBRES, N_APELLIDOS, N_CARGO) values ('CE', 3, 'Daniel', 'Zantana', 'Cargo Prueba2');

--Estudiante
REM INSERTING into Estudiante
INSERT into Estudiante (K_CODIGO, N_NOMBRE, Q_RENOVACIONES, Q_CREDITOS_INS, I_PERIODO_ACT) values (20151020021, 'Jhon Malagon', 7, 17, 3);
INSERT into Estudiante (K_CODIGO, N_NOMBRE, Q_RENOVACIONES, Q_CREDITOS_INS, I_PERIODO_ACT) values (20151020001, 'Daniel Ariza', 10, 18, 3);
INSERT into Estudiante (K_CODIGO, N_NOMBRE, Q_RENOVACIONES, Q_CREDITOS_INS, I_PERIODO_ACT) values (20151020002, 'Mateo Ortega', 5, 16, 3);
INSERT into Estudiante (K_CODIGO, N_NOMBRE, Q_RENOVACIONES, Q_CREDITOS_INS, I_PERIODO_ACT) values (20151020003, 'David Bohorquez', 12, 17, 3);
INSERT into Estudiante (K_CODIGO, N_NOMBRE, Q_RENOVACIONES, Q_CREDITOS_INS, I_PERIODO_ACT) values (20151020004, 'Johan Ricardo', 5, 10, 3);

--Funcionario
REM INSERTING into Funcionario
INSERT into Funcionario (K_ID, N_NOMBRE, N_APELLIDO, N_CARGO) values (2, 'Pepita', 'Perez', 'Cargo Prueba');
INSERT into Funcionario (K_ID, N_NOMBRE, N_APELLIDO, N_CARGO) values (4, 'Federico', 'Castro', 'Cargo Prueba2');
INSERT into Funcionario (K_ID, N_NOMBRE, N_APELLIDO, N_CARGO) values (5, 'Angela', 'Perez', 'Cargo Prueba3');

--Actividad
REM INSERTING into  Actividad
INSERT into Actividad (K_ID, F_REALIZACION, O_LUGAR, O_DESCRIPCION, ID_FUNCIONARIO) values (1, to_date('2021/04/25', 'YYYY/MM/DD'), 'Bogota', 'Prueba de Actividad01', 2);
INSERT into Actividad (K_ID, F_REALIZACION, O_LUGAR, O_DESCRIPCION, ID_FUNCIONARIO) values (2, to_date('2021/03/30', 'YYYY/MM/DD'), 'Meta', 'Prueba de Actividad02', 5);

--Categoria
REM INSERTING into Categoria
INSERT into Categoria (K_ID, O_DESCRIPCION, ID_CONVOCATORIA) values (1, 'ESTO ES UNA PRUEBA', 1);
INSERT into Categoria (K_ID, O_DESCRIPCION, ID_CONVOCATORIA) values (2, 'ESTO ES UNA PRUEBA', 2);
INSERT into Categoria (K_ID, O_DESCRIPCION, ID_CONVOCATORIA) values (3, 'ESTO ES UNA PRUEBA2', 2);

--Condicion
REM INSERTING into Condicion
INSERT into Condicion (K_CONECUTIVO, K_ID_CATEGORIA, O_DESCRIPCION, Q_PUNTAJE) values (1, 1, 'Esto es una prueba', 30);
INSERT into Condicion (K_CONECUTIVO, K_ID_CATEGORIA, O_DESCRIPCION, Q_PUNTAJE) values (2, 3, 'Esto es una prueba', 50);

--Coordinador_Convocatoria
REM INSERTING into Coordinador_Convocatoria
INSERT into Coordinador_Convocatoria (K_TIPO_ID_COORDINADOR, K_ID_COORDINADOR, K_ID_CONVOCATORIA) values ('CC', 1, 1);
INSERT into Coordinador_Convocatoria (K_TIPO_ID_COORDINADOR, K_ID_COORDINADOR, K_ID_CONVOCATORIA) values ('CE', 3, 2);

--Solicitud
REM INSERTING into Solicitud
INSERT into Solicitud (K_ID, F_REALIZACION, I_ESTADO, O_OBSERVACION, ID_CONVOCATORIA, K_ID_ESTUDIANTE) values (1, to_date('2021/03/08', 'YYYY/MM/DD'), 'E', 'Prueba', 1, 20151020021);
INSERT into Solicitud (K_ID, F_REALIZACION, I_ESTADO, O_OBSERVACION, ID_CONVOCATORIA, K_ID_ESTUDIANTE) values (2, to_date('2021/06/09', 'YYYY/MM/DD'), 'E', 'Prueba', 2, 20151020003);
INSERT into Solicitud (K_ID, F_REALIZACION, I_ESTADO, O_OBSERVACION, ID_CONVOCATORIA, K_ID_ESTUDIANTE) values (3, to_date('2021/06/07', 'YYYY/MM/DD'), 'R', 'Prueba', 2, 20151020004);
INSERT into Solicitud (K_ID, F_REALIZACION, I_ESTADO, O_OBSERVACION, ID_CONVOCATORIA, K_ID_ESTUDIANTE) values (4, to_date('2021/03/10', 'YYYY/MM/DD'), 'R', 'Prueba', 1, 20151020002);

--Soporte
REM INSERTING into Soporte
INSERT into Soporte (K_ID, O_DESCRIPCION, I_TIPO, I_ESTADO, I_DOCUMENTO, Q_PUNTAJE, ID_CATEGORIA) values (1, 'Descripcion del estado', 'Estado', 'PASS','', 80, 1);
INSERT into Soporte (K_ID, O_DESCRIPCION, I_TIPO, I_ESTADO, I_DOCUMENTO, Q_PUNTAJE, ID_CATEGORIA) values (2, 'Descripcion del estado', 'Estado', 'FAIL','', 20, 1);

--Solicitud_Soporte
REM INSERTING into Solicitud_Soporte
INSERT into Solicitud_Soporte (ID_SOLICITUD, ID_SOPORTE) values (1, 1);
INSERT into Solicitud_Soporte (ID_SOLICITUD, ID_SOPORTE) values (2, 1);

--Funcionario_Solicitud
REM INSERTING into Funcionario_Solicitud
INSERT into Funcionario_Solicitud (ID_FUNCIONARIO, ID_SOLICITUD, F_ACTUALIZACION, O_OBSERVACION) values (2, 1, to_date('2021/03/10', 'YYYY/MM/DD'), 'Descripcion de prueba');
INSERT into Funcionario_Solicitud (ID_FUNCIONARIO, ID_SOLICITUD, F_ACTUALIZACION, O_OBSERVACION) values (4, 2, to_date('2021/06/11', 'YYYY/MM/DD'), 'Descripcion de prueba');
INSERT into Funcionario_Solicitud (ID_FUNCIONARIO, ID_SOLICITUD, F_ACTUALIZACION, O_OBSERVACION) values (5, 3, to_date('2021/06/09', 'YYYY/MM/DD'), 'Descripcion de prueba');

--Subsidio
REM INSERTING into Subsidio
INSERT into Subsidio (K_ID, I_TIPO, ID_CONVOCATORIA) values (1, 'A', 1);
INSERT into Subsidio (K_ID, I_TIPO, ID_CONVOCATORIA) values (2, 'B', 1);
INSERT into Subsidio (K_ID, I_TIPO, ID_CONVOCATORIA) values (3, 'T', 2);

--Tipo_Subsidio
REM INSERTING into Tipo_Subsidio
INSERT into Tipo_Subsidio (K_ID, I_HORARIO, Q_CUPOS, ID_SUBSIDIO) values (1, 'D', 150, 1);
INSERT into Tipo_Subsidio (K_ID, I_HORARIO, Q_CUPOS, ID_SUBSIDIO) values (2, 'N', 100, 3);

--Beneficio
REM INSERTING into Beneficio
INSERT into Beneficio (K_ID, I_ESTADO, O_OBSERVACION, ID_TIPO_SUBSIDIO) values (1, 'R', 'Esto es una prueba', 1);
INSERT into Beneficio (K_ID, I_ESTADO, O_OBSERVACION, ID_TIPO_SUBSIDIO) values (2, 'C', 'Esto es una prueba', 2);

--Beneficio_Actividad
REM INSERTING into Beneficio_Actividad
INSERT into Beneficio_Actividad (ID_BENEFICIO, ID_ACTIVIDAD) values (1, 2);
INSERT into Beneficio_Actividad (ID_BENEFICIO, ID_ACTIVIDAD) values (2, 1);

--Tiquetera
REM INSERTING into Tiquetera
INSERT into Tiquetera (K_ID, F_ENTREGA, Q_TIQUETES, O_PORCENTAJE_PAGO, ID_BENEFICIO, V_PRECIO) values (1, to_date('2021/03/30', 'YYYY/MM/DD'), 70, 25, 1, 100000);
INSERT into Tiquetera (K_ID, F_ENTREGA, Q_TIQUETES, O_PORCENTAJE_PAGO, ID_BENEFICIO, V_PRECIO) values (2, to_date('2021/06/30', 'YYYY/MM/DD'), 50, 50, 2, 50000);

--Pago
REM INSERTING into Pago
INSERT into Pago (K_ID, F_PAGO, V_PAGO, ID_TIQUETERA) values (1, to_date('2021/03/29', 'YYYY/MM/DD'), 150000, 1);
INSERT into Pago (K_ID, F_PAGO, V_PAGO, ID_TIQUETERA) values (2, to_date('2021/06/29', 'YYYY/MM/DD'), 50000, 2);

--Tiquete
REM INSERTING into Tiquete
INSERT into Tiquete (K_NUMERO, F_UTILIZACION, I_ESTADO, ID_TIQUETERA) values (1, to_date('2021/04/08', 'YYYY/MM/DD'), 'E', 2);
INSERT into Tiquete (K_NUMERO, F_UTILIZACION, I_ESTADO, ID_TIQUETERA) values (2, to_date('2021/08/08', 'YYYY/MM/DD'), 'U', 1);


/*
PLANTILLA

REM INSERTING into 
INSERT into  () values ();*/




