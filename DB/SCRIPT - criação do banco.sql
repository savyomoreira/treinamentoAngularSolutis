CREATE SCHEMA `base_tcc` DEFAULT CHARACTER SET utf8 ;


drop table IF EXISTS USUARIO; 
create table USUARIO(
  id INT(6) primary key AUTO_INCREMENT,
  nome varchar(100) not null,
  sexo varchar(9) not null CHECK (sexo = 'MASCULINO' or 'FEMININO'),
  senha varchar(8) not null,
  email varchar(50) not null,
  telefone varchar(50) not null,
  endereco varchar(100) not null,
  bairro varchar(100) not null,
  cidade varchar(100) not null,
  estado varchar(100) not null,
  cep varchar(15) not null,
  complemento varchar(100)
);

drop table IF EXISTS ANUNCIO;
create table ANUNCIO(
  id INT(6) primary key AUTO_INCREMENT,
  descricao varchar(100) not null,
  id_usuario INT(6)
);

create table AGENDAMENTO(
	ID_AGENDAMENTO int(6) primary key auto_increment,
    ID_ANUNCIO INT,
    ID_USUARIO_CONTRATANTE INT,
    DATA_AGENDAMENTO datetime,
    COMENTARIO varchar(200)
);

DROP TABLE if exists AVALIACAO;
create table AVALIACAO(
	ID_AVALIACAO int(6) primary key auto_increment,
    ID_AGENDAMENTO INT NOT NULL,
    DATA_AVALIACAO datetime NOT NULL,
    NOTA INT NOT NULL, 
    COMENTARIO varchar(200) NOT NULL
);

create table FOTOS_ANUNCIO(
id_anuncio int(6) primary key auto_increment ,
foto longblob  not null 
);

ALTER TABLE FOTOS_ANUNCIO
ADD FOREIGN KEY (id_anuncio) REFERENCES ANUNCIO(id); 


ALTER TABLE AVALIACAO
ADD FOREIGN KEY (ID_AGENDAMENTO) REFERENCES AGENDAMENTO(ID_AGENDAMENTO); 

ALTER TABLE ANUNCIO
ADD FOREIGN KEY (id_usuario) REFERENCES USUARIO(id); 

ALTER TABLE AGENDAMENTO
ADD FOREIGN KEY (ID_USUARIO_CONTRATANTE) REFERENCES USUARIO(id); 

ALTER TABLE AGENDAMENTO
ADD FOREIGN KEY (ID_ANUNCIO) REFERENCES ANUNCIO(id); 


ALTER TABLE ANUNCIO
CHANGE COLUMN descicao descricao varchar(100);

https://sourceforge.net/projects/projectlibre/files/ProjectLibre/1.5.1/



