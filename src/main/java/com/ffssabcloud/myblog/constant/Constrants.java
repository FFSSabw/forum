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
        public static final int UNAUTH = 0;
        public static final int AUTHED = 1;
        public static final int ADMIN = 2;
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
        public static final String COOKIE_NAME = "ASessionId";
        public static final String COOKIE_VALUE_SEPARATOR = "ASessionId";
        public static final String COOKIE_SALT = "qwegmkmv;l;";
        public static final String USER_CACHE_PREFIX = "U_::";
        public static final String LOCAL_AUTH_CACHE_PREFIX = "L_A::";
    }
}
