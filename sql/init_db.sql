CREATE DATABASE myblog DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use myblog

CREATE TABLE t_user (
    id INT UNSIGNED auto_increment,
    username VARCHAR(64) unique NOT NULL,
    description VARCHAR(1024),
    location VARCHAR(512),
    registerBy VARCHAR(16),
    PRIMARY KEY(id)
)ENGINE=InnoDB, auto_increment=100000;

insert into t_user(username, registerBy, description) values('admin', 'LOCAL', '用户管理员');

CREATE TABLE t_local_auth (
    username VARCHAR(64) unique NOT NULL,
    password VARCHAR(256) NOT NULL,
    roleId INT UNSIGNED NOT NULL DEFAULT 0,
    PRIMARY KEY(username)
)ENGINE=InnoDB;

insert into t_local_auth(roleId, username, password) values(2, 'admin', '91a2d41408eb9bf69e88b3f7eeced4f3');

CREATE TABLE t_role (
    id INT UNSIGNED,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE t_article (
    id INT UNSIGNED AUTO_INCREMENT,
    authorId INT UNSIGNED NOT NULL,
    categories VARCHAR(64) NOT NULL,
    title VARCHAR(128) NOT NULL,
    createAt INT UNSIGNED NOT NULL,
    modifyAt INT UNSIGNED NOT NULL,
    description TEXT NOT NULL,
    content TEXT NOT NULL,
    status BOOLEAN NOT NULL,
    clicks INT UNSIGNED NOT NULL,
    tags VARCHAR(256),
    comments INT UNSIGNED NOT NULL DEFAULT 0,
    allowComment BOOLEAN,

    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE t_meta (
    id INT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL UNIQUE,
    type VARCHAR(64) NOT NULL,
    count INT,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

insert into t_meta(name,type, count) values('默认分类', 'categories', 0);

CREATE TABLE t_comment (
    id INT UNSIGNED AUTO_INCREMENT,
    author VARCHAR(64) NOT NULL,
    authorId INT UNSIGNED NOT NULL,
    articleId INT UNSIGNED NOT NULL,
    articleTitle VARCHAR(128) NOT NULL,
    replyId INT UNSIGNED,
    reply VARCHAR(64),
    createAt INT UNSIGNED NOT NULL,
    content TEXT NOT NULL,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE t_option (
    name varchar(32) NOT NULL,
    value varchar(1024) DEFAULT '',
    description varchar(1024) DEFAULT NULL,
    PRIMARY KEY(name)
)ENGINE=InnoDB;

INSERT INTO t_option (name, value, description)
VALUES
    ('site_title', 'My Blog',''),
    ('social_weibo', '',NULL),
    ('social_zhihu', '',NULL),
    ('social_github', '',NULL),
    ('site_description', '这是一个分享知识的博客',NULL),
    ('site_record', '','备案号');
