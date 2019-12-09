
create table rol (
  rol_id number(10) not null,
  rol_nombre varchar2(50) not null UNIQUE,
  rol_id_personaje number(3) not null,
  rol_estado varchar2(50 char) not null,  
  constraint "rol_estado_CHK" check (rol_estado IN('ACTIVO','INACTIVO')),
  constraint "PK_Rol" PRIMARY KEY (rol_id),
  constraint "FK_Rol" FOREIGN KEY (rol_id_personaje) REFERENCES personaje (PERS_ID)
);

create sequence "SEC_ROL" minvalue 1 start with 1 increment by 1;

ALTER TABLE personaje
ADD CONSTRAINT "UC_PERSONAJE_NOMBRE"
  UNIQUE (pers_nombre);


insert into rol (rol_id, rol_nombre, rol_id_personaje, rol_estado)
VALUES (1, 'HEROE',  1, 'ACTIVO');
insert into rol (rol_id, rol_nombre, rol_id_personaje, rol_estado)
VALUES (2, 'PIRATA',  2, 'ACTIVO');
insert into rol (rol_id, rol_nombre, rol_id_personaje, rol_estado)
VALUES (3, 'SAYAYIN',  3, 'ACTIVO');