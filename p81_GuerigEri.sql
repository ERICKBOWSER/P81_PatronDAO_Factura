
CREATE DATABASE p81_GuerigEri;
USE p81_GuerigEri;

CREATE TABLE IF NOT EXISTS factura
(
	codigo VARCHAR(20),
    fechaEmision DATE,
    descripcion VARCHAR(50),
    totalImporteFactura DECIMAL(5, 2),
    
    CONSTRAINT pk_factura PRIMARY KEY(codigo)
);

DROP TABLE factura;

























