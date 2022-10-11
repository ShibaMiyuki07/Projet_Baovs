create database Tennis;

\c Tennis;

-- create table game(idgame serial primary key,nom_game text);

-- create table Joueur(idJoueur serial primary key,NomJoueur text);

-- create table points(idpoints serial primary key,point text);

-- create table point_joueur(idpoint_joueur serial,idpoints int,idgame int,idJoueur int);

-- create table coordonne_terrain(idcoordonne_terrain serial primary key,nom_terrain text,coordonneX int,coordonneY int,width int,height int);

-- alter table point_joueur add foreign key(idpoints) references points(idpoints); 

-- alter table point_joueur add foreign key(idgame) references game(idgame); 

-- alter table point_joueur add foreign key(idJoueur) references Joueur(idJoueur); 

-- insert into coordonne_terrain(nom_terrain,coordonneX,coordonneY,width,height) values('FullCourt',100, 100, 700, 900),('DoubleGauche',100, 100, 100, 900),('DoubleDroite',700, 100, 100, 900),('ZoneServiceHaut',200,325, 500, 225),('ZoneServiceBas',200,550, 500, 225),('ZoneServiceHautGauche',200, 325, 250, 225),('ZoneServiceHautDroite',450, 325, 250, 225),('ZoneServiceBasGauche',200, 550, 250, 225),('ZoneServiceBasDroite',450, 550, 250, 225);

-- insert into points(point) values('0'),('15'),('30'),('45');   

-- insert into Joueur(NomJoueur) values('joueur1'),('joueur2');

-- UPDATE Joueur SET idJoueur = '2' WHERE idJoueur = '1';

-- UPDATE coordonne_terrain SET nom_terrain = 'filet' WHERE nom_terrain = 'fillet';

-- insert into coordonne_terrain (nom_terrain,coordonneX,coordonneY,width,height) values ('fillet',100, 550, 800, 550);

--new base:
create table Joueur(idJoueur serial primary key,NomJoueur text);

create table Game(idJoueur int,nbr_game_win int);  
        
create table Sets(idJoueur int,nbr_set_win int);
        
create table Points(idpoints serial primary key,points text);

create table Point_joueur(idJoueur int ,idpoints int);
        
        alter table Point_joueur add foreign key(idJoueur) references Joueur(idJoueur);
        alter table Point_joueur add foreign key(idpoints) references Points(idpoints);
        alter table Game add foreign key(idJoueur) references Joueur(idJoueur); 
        alter table Seta add foreign key(idJoueur) references Joueur(idJoueur);
   

create table coordonne_terrain(idcoordonne_terrain serial primary key,nom_terrain text,coordonneX int,coordonneY int,width int,height int);

--insert
--coordonnee:
insert into coordonne_terrain(nom_terrain,coordonneX,coordonneY,width,height) values('FullCourt',100, 100, 700, 900),
('DoubleGauche',100, 100, 100, 900),('DoubleDroite',700, 100, 100, 900),('ZoneServiceHaut',200,325, 500, 225)
,('ZoneServiceBas',200,550, 500, 225),('ZoneServiceHautGauche',200, 325, 250, 225),('ZoneServiceHautDroite',450, 325, 250, 225),
('ZoneServiceBasGauche',200, 550, 250, 225),('ZoneServiceBasDroite',450, 550, 250, 225),('filet',100, 550, 800, 550);
--table tsotra
insert into Joueur(NomJoueur) values('joueur1'),('joueur2'),('joueur3'),('joueur4'),('joueur5');

insert into Points(points) values('0'),('15'),('30'),('40'); 

--view:
create view All_info_joueur as 

select as.NomJoueur,Point_joueur.idpoints, Game.nbr_game_win,Seta.nbr_set_win from Joueur
join Point_joueur on Joueur.idJoueur = Point_joueur.id_point 
join Game on Joueur.idJoueur = Game.idJoueur
join Seta on Joueur.idJoueur = Seta.idJoueur;


