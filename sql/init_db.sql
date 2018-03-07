CREATE DATABASE forum_user DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use forum_user;

CREATE TABLE user (
    id INT auto_increment,
    name VARCHAR(128),
    PRIMARY KEY(id)
);

CREATE DATABASE forum_post DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use forum_post;

CREATE TABLE post (
    id INT auto_increment,
    name VARCHAR(128),
    PRIMARY KEY(id)
)
