CREATE TABLE cuenta(
idUsuario int(10) PRIMARY KEY auto_increment,
usuario varchar(10) DEFAULT NULL,
contraseña varchar(10) DEFAULT NULL
);cuenta

CREATE TABLE personaje(
idUsuarioCuenta int(10),
nickName varchar(10) PRIMARY KEY not null,
vida int not null,
mana int not null,
nivel int not null,
raza varchar(10) not null,
descripccion varchar(30) not null
);

ALTER TABLE personaje ADD CONSTRAINT cue_per_fk 
FOREIGN KEY (idUsuarioCuenta) REFERENCES cuenta(idUsuario);