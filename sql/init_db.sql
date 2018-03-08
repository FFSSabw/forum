CREATE DATABASE forum_user DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use forum_user;

CREATE TABLE users (
    id INT UNSIGNED auto_increment,
    rid TINYINT UNSIGNED not null DEFAULT 0,
    email VARCHAR(256) unique not null,
    description VARCHAR(1024),
    location VARCHAR(512),
    username VARCHAR(128) unique not null,
    password VARCHAR(512) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB, auto_increment=100000;

CREATE TABLE roles (
    id TINYINT UNSIGNED,
    name VARCHAR(32) not null,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE user_role_rel (
    id INT UNSIGNED auto_increment,
    user_id INT UNSIGNED,
    role_id TINYINT UNSIGNED DEFAULT 0,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE DATABASE forum_post DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use forum_post;

CREATE TABLE posts (
    id INT auto_increment,
    name VARCHAR(16),
    PRIMARY KEY(id)
)
