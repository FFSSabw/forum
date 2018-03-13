package com.ffssabcloud.myblog.constant;

public interface Constrants {
    
    /**
     * 公共常量
     *
     */
    public static class Public {
        
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
    
    public static class Register {
        public static final String LOCAL = "LOCAL";
        public static final String OAUTH = "OAUTH";
    }
}
