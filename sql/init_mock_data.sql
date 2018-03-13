use myblog
insert into Roles(id, name) values(0, 'ROLE_UNAUTH');
insert into Roles(id, name) values(1, 'ROLE_AUTHED');
insert into Roles(id, name) values(2, 'ROLE_ADMIN');

insert into Users(name, description, location) values("Bob", 'Im Bob', "new york");
insert into Users(name, description, location) values("fun", 'Im fun', "shanghai");
insert into Users(name, description, location) values("lucky", 'Im lucky', "tokyo");

insert into LocalAuth(user_id, email, username, password) values(100000, '123456@gmail.com', "username_a", "123456");
insert into LocalAuth(user_id, role_id, email, username, password) values(100001, 1, "123456@163.com", "username_b", "123456");
insert into LocalAuth(user_id, role_id, email, username, password) values(100002, 2, "123456@qq.com", "username_c", "123456");

-- insert into UserRoleRela(user_id, role_id) values(100000, 0);
-- insert into UserRoleRela(user_id, role_id) values(100000, 1);
-- insert into UserRoleRela(user_id, role_id) values(100000, 2);