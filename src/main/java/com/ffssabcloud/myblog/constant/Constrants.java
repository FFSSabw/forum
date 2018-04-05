package com.ffssabcloud.myblog.constant;

public interface Constrants {
    
    /**
     * 公共常量
     *
     */
    public static class Public {
        public static final String COOKIE_NAME = "ASessionId";
    }
    
    /**
     * rest风格返回值常量
     *
     */
    public static class RestResponse {
        public static final int FAIL = 0;
        public static final int SUCCESS = 1;
    }
    
    /**
     * 用户权限
     *
     */
    public static class Roles {
        public static final Integer UNAUTH = 0;
        public static final Integer AUTHED = 1;
        public static final Integer ADMIN = 2;
    }
    
    /**
     * 用户注册
     *
     */
    public static class Register {
        public static final String LOCAL = "LOCAL";
        public static final String OAUTH = "OAUTH";
    }
    
    /**
     * Web
     *
     */
    public static class Web {
        public static final String COOKIE_NAME = "SESSION";
        public static final String COOKIE_SALT = "qwegmkmv;l;";
        public static final int MAX_PAGE = 64;
        public static final String SESSION_USERINFO_NAME = "userInfo";
    }
    
    /**
     * 文章
     *
     */
    public static class Article {
        public static final boolean PUBLISHED = true;
        public static final boolean UNPUBLISHED = false;
    }
    
    public static class Types {
        public static final String CATEGORIES = "categories";
        public static final String TAG = "tag";
    }
}
