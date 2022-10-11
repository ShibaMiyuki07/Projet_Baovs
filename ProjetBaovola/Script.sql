/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Manitra
 * Created: 6 oct. 2022
 */

create database projet_baovola;

\c projet_baovola;

--Nouvelle table 
create table candidat(idCandidat serial primary key,nom text,prenom text,adresse varchar(15),datenaissance text,idecoleorigine int);

create table bacc(idbacc serial primary key,serie char(3));

create table type_bacc(idtype_bacc serial primary key,nom_type_bacc text);

create table filiere(idfiliere serial primary key,nomfiliere text);

create table filiere_candidat(idCandidat int,idbacc int,idfiliere int,idpromotion int);

create table note_candidat(idCandidat int,idbacc int,note_francais float,note_maths float,note_ang float);

create table promotion(idpromotion serial primary key,nom_promotion text,datedebut text,datefin text,idfiliere int);
--Ancienne table
create table region(idregion serial primary key,nom_region text);

create table ecoleorigine(idecoleorigine serial primary key,nom_ecoleorigine text,idregion int not null); 

create table inscription_design(idInscription_design serial primary key,idCandidat int);

create table inscription_info(idInscription_info serial primary key,idCandidat int);


--Ajout des contraintes
alter table candidat add foreign key(idecoleorigine) references ecoleorigine(idecoleorigine);

alter table ecoleorigine add foreign key(idregion) references region(idregion);

alter table bacc add foreign key(idtype_bacc) references type_bacc(idtype_bacc);

alter table filiere_candidat add foreign key(idpromotion) references promotion(idpromotion);

--Insertion des donnes

insert into filiere(nomfiliere) values('info'),('design');

insert into bacc(serie,idtype_bacc) values('A1','1'),('A2','1'),('C','2'),('D','2'),('S','2'),('T','2');

insert into type_bacc(nom_type_bacc) values('literraire'),('scientifique');

insert into promotion(nom_promotion,datedebut,datefin,idfiliere) values('P17','2023','2024','1'),('P4','2023','2024','2');

--Creation des differents vues
create view details_bacc_candidat as select note_candidat.idcandidat,nom,prenom,note_candidat.idbacc,bacc.serie,note_maths,note_ang,note_francais from note_candidat,candidat,bacc where note_candidat.idcandidat = candidat.idcandidat and note_candidat.idbacc = bacc.idbacc;


create view choix_filiere_candidat as select filiere_candidat.idcandidat,nom,prenom,filiere_candidat.idfiliere,nomfiliere,filiere_candidat.idpromotion,nom_promotion from filiere_candidat,candidat,filiere,promotion where filiere_candidat.idcandidat = candidat.idcandidat and filiere_candidat.idfiliere = filiere.idfiliere and filiere_candidat.idpromotion = promotion.idpromotion;
