use myblog
insert into Meta(name,type, count) values('后端', 'categories', 100);
insert into Meta(name,type, count) values('前端', 'categories', 200);
insert into User(username, registerBy) values('admin', 'LOCAL');
insert into LocalAuth(roleId, username, password) values(2, 'admin', '91a2d41408eb9bf69e88b3f7eeced4f3');