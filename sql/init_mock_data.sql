use forum_user
insert into users(username, email, password) values("username_A", '123456@qq.com', "password_A");
insert into users(username, email, password) values("username_B", '123456@128.com', "password_B");
insert into users(username, email, password) values("username_C", '123456@163.com', "password_C");

insert into roles(id, name) values(0, 'ROLE_UNAUTH');
insert into roles(id, name) values(1, 'ROLE_AUTHED');
insert into roles(id, name) values(2, 'ROLE_ADMIN');

insert into user_role_rel(user_id, role_id) values(100000, 0);
insert into user_role_rel(user_id, role_id) values(100000, 1);
insert into user_role_rel(user_id, role_id) values(100000, 2);