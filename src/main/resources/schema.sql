CREATE TABLE IF NOT EXISTS USUARIO(
  ID int not null AUTO_INCREMENT,
  NOMBRE varchar(100) not null,
  NUMERODOCUMENTO varchar(50) not null,
  ESTADO int,
  TIPO varchar(100) not null,
  PRIMARY KEY ( ID )
);

CREATE TABLE IF NOT EXISTS CUENTA(
  ID int not null AUTO_INCREMENT,
  ESTADO int,
  NUMERO varchar(200) not null,
  IDUSUARIO int ,
  PRIMARY KEY ( ID ),
  FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(ID)
);

CREATE TABLE IF NOT EXISTS MOVIMIENTO(
  ID int not null AUTO_INCREMENT,
  IDCUENTA INT,
  DESCRIPCION VARCHAR(200)  ,
  INTERESES DOUBLE  ,
  PRIMARY KEY ( ID ),
  FOREIGN KEY (IDCUENTA) REFERENCES CUENTA(ID)
);

INSERT INTO USUARIO (NOMBRE,NUMERODOCUMENTO,ESTADO,TIPO) VALUES ('Carlos Belloda Saavedra','dni-43843823',1,'PREMIUM');
INSERT INTO USUARIO (NOMBRE,NUMERODOCUMENTO,ESTADO,TIPO) VALUES ('Rossmery Salvatierra','dni-40012342',1,'NORMAL');

INSERT INTO CUENTA (ESTADO, NUMERO,IDUSUARIO) VALUES (1,'3321-2333-2231-3231',1);
INSERT INTO CUENTA (ESTADO, NUMERO,IDUSUARIO) VALUES (1,'2131-2233-4432-2342',1);
INSERT INTO CUENTA (ESTADO, NUMERO,IDUSUARIO) VALUES (1,'3333-2233-4432-2342',2);

INSERT INTO MOVIMIENTO (IDCUENTA,DESCRIPCION,INTERESES) VALUES (1,'CAMISETA',0.4);
INSERT INTO MOVIMIENTO (IDCUENTA,DESCRIPCION,INTERESES) VALUES (2,'IPAD',0.3);
INSERT INTO MOVIMIENTO (IDCUENTA,DESCRIPCION,INTERESES) VALUES (1,'CELULAR',0.2);
INSERT INTO MOVIMIENTO (IDCUENTA,DESCRIPCION,INTERESES) VALUES (1,'COMIDA',0.1);

INSERT INTO MOVIMIENTO (IDCUENTA,DESCRIPCION,INTERESES) VALUES (3,'CAMISETA',0.4);
INSERT INTO MOVIMIENTO (IDCUENTA,DESCRIPCION,INTERESES) VALUES (3,'PUSERA',0.1);
INSERT INTO MOVIMIENTO (IDCUENTA,DESCRIPCION,INTERESES) VALUES (3,'LAVADORA',0.1);


