CREATE DATABASE myblog DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use myblog

CREATE TABLE User (
    id INT UNSIGNED auto_increment,
    username VARCHAR(64) unique not null,
    description VARCHAR(1024),
    location VARCHAR(512),
    registerBy VARCHAR(16),
    PRIMARY KEY(id)
)ENGINE=InnoDB, auto_increment=100000;

CREATE TABLE LocalAuth (
    id INT UNSIGNED auto_increment,
    roleId INT UNSIGNED not null DEFAULT 0,
    username VARCHAR(64) unique not null,
    password VARCHAR(256) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE Role (
    id INT UNSIGNED,
    name VARCHAR(32) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

-- CREATE TABLE Article (
--     id INT UNSIGNED AUTO_INCREMENT,
--     title VARCHAR(128) NOT NULL,
--     createAt INT UNSIGNEDNOT NULL,
--     modifyAt INT UNSIGNEDNOT NULL,
--     description TEXT NOT NULL,
--     content TEXT NOT NULL,
--     status BOOLEAN NOT NULL,
--     clicks INT UNSIGNED NOT NULL,
--     tags VARCHAR(256),
--     PRIMARY KEY(id)
-- )ENGINE=InnoDB;
