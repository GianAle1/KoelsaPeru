use koelsa

select * from maquinaria

INSERT INTO maquinaria (nombre,modelo, idmarca)
VALUES ('Asfaltadora', '1648 Plus 48HP',1);

insert into marca(nombre)
values('Caterpilla')
SELECT nombre FROM marca
CREATE TABLE marca (
    idmarquinaria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    idmarca int
);

CREATE TABLE marca (
    idmarca INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);
ALTER TABLE maquinaria
ADD CONSTRAINT fk_idmarca FOREIGN KEY (idmarca) REFERENCES marca(idmarca);
