CREATE DATABASE Registro;
USE Registro;
#drop schema registro;


CREATE TABLE Administrador (
	id int primary key auto_increment,
    nome VARCHAR(50) NULL, 
    email VARCHAR(50) NULL,
    senha VARCHAR(11) NULL
);

CREATE TABLE Aluno (
  id_matri INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  matricula VARCHAR(11) NULL,
  curso VARCHAR(50) NULL,
  PRIMARY KEY (id_matri)
);
  
  CREATE TABLE Funcionario (
   id int primary key auto_increment,
   nome VARCHAR(50) NULL,
   cpf VARCHAR(20) NULL,
   email VARCHAR(50) NULL
);

SELECT * FROM Administrador;
SELECT * FROM Aluno;
SELECT * FROM Funcionario;