create table VISITOR (
    id int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    email varchar(100) not null,
    coming_from varchar(100) not null,
    comments varchar(100) not null,
    PRIMARY KEY (id)
);
