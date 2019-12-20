create table cliente (
  cliente_id number(10) not null,
  cliente_nombre varchar2(50) not null,
  cliente_tipo_documento varchar2(50 char) not null,
  cliente_documento varchar2(20 char) not null,
  cliente_fecha date,
  constraint "cliente_tipo_documento_CHK" check (cliente_tipo_documento IN('TARJETA_DE_IDENTIDAD','CEDULA_DE_CIUDADANIA', 'CEDULA_DE_EXTRANGERIA','PASAPORTE')),
  constraint "PK_cliente" PRIMARY KEY (cliente_id)
);

CREATE SEQUENCE "DB_SEMILLERO"."SEC_CLIENTE" MINVALUE 1 START WITH 1  INCREMENT BY 1 NOCACHE;



insert into cliente (cliente_id, cliente_nombre, cliente_tipo_documento, cliente_documento, cliente_fecha)
VALUES (DB_SEMILLERO.SEC_CLIENTE.nextval, 'Nameku',  'CEDULA_DE_CIUDADANIA', '123456789', '10/10/1987');
insert into cliente (cliente_id, cliente_nombre, cliente_tipo_documento, cliente_documento, cliente_fecha)
VALUES (DB_SEMILLERO.SEQ_COMIC.nextval, 'Kurririn',  'CEDULA_DE_CIUDADANIA', '987654321', '12/121987');
insert into cliente (cliente_id, cliente_nombre, cliente_tipo_documento, cliente_documento, cliente_fecha)
VALUES (DB_SEMILLERO.SEQ_COMIC.nextval, 'Broly',  'CEDULA_DE_CIUDADANIA', '6789054321', '12/121987');

SELECT * FROM cliente;

--nueva tabla

create table cliente_comic (
  cliente_id number(10) not null,
  SCID NUMBER(3,0) NOT NULL ENABLE,
  c_c_fecha_venta date,
  constraint fk_cliente_comic_cliente
  foreign key (cliente_id) references cliente (cliente_id),
  constraint fk_cliente_comic_comic
  foreign key (SCID) references comic(SCID)
);

insert into cliente_comic (cliente_id, SCID, c_c_fecha_venta)
VALUES ('2','1', sysdate);
insert into cliente_comic (cliente_id, SCID, c_c_fecha_venta)
VALUES ('10','2', sysdate);
insert into cliente_comic (cliente_id, SCID, c_c_fecha_venta)
VALUES ('11','2', sysdate);
SELECT * FROM COMIC
SELECT * FROM cliente_comic