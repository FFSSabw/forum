use myblog
-- insert into Meta(name,type, count) values('默认分类', 'categories', 0);
-- insert into User(username, registerBy) values('admin', 'LOCAL');
-- insert into LocalAuth(roleId, username, password) values(2, 'admin', '91a2d41408eb9bf69e88b3f7eeced4f3');

INSERT INTO t_option (name, value, description)
VALUES
    ('title', 'My Blog',''),
    ('social_weibo', '',NULL),
    ('social_zhihu', '',NULL),
    ('social_github', '',NULL),
    ('site_description', '这是一个分享知识的博客',NULL),
    ('site_record', '','备案号');