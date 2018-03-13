CREATE DATABASE myblog DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use myblog

CREATE TABLE Users (
    id INT UNSIGNED auto_increment,
    username VARCHAR(64) unique not null,
    description VARCHAR(1024),
    location VARCHAR(512),
    registerBy VARCHAR(16),
    PRIMARY KEY(id)
)ENGINE=InnoDB, auto_increment=100000;

CREATE TABLE LocalAuths (
    id INT UNSIGNED auto_increment,
    roleId TINYINT UNSIGNED not null DEFAULT 0,
    username VARCHAR(64) unique not null,
    password VARCHAR(256) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Roles (
    id TINYINT UNSIGNED,
    name VARCHAR(32) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB;


