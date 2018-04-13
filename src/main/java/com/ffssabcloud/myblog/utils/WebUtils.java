package com.ffssabcloud.myblog.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import static org.apache.commons.codec.digest.MessageDigestAlgorithms.MD5;

import org.springframework.beans.factory.annotation.Autowired;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.auth.Localauth;
import com.ffssabcloud.myblog.domain.auth.UserInfo;

public class WebUtils {
    
    private static DigestUtils digest = new DigestUtils(MD5);
    private static String defaultSalt = Constrants.Web.COOKIE_SALT;
    
    @Autowired
    Commons commons;
    
    public static boolean permissionCheck(String uri, String startWith, Integer role, UserInfo userInfo) {
        if(uri.startsWith(startWith) && (userInfo == null || 
                !(role.equals(((Localauth)userInfo.getAuth()).getRoleid())))) {
            return false;
        }
        return true;
    }
  
    public static void removeCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setValue(null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    
    public static void removeLoginCookie(HttpServletResponse response) {
        removeCookie(response, Constrants.Web.SESSION_NAME);
    }
    
    public String[] splitCookie(String cookieValue) {
        return cookieValue.split(":");
    }
    
    public void setCookie(HttpServletResponse response, Cookie cookie) {
        response.addCookie(cookie);
    }
    
    public static String hashWithSalt(String raw) {
        return hashWithSalt(raw, defaultSalt);
    }
    
    public static String hashWithSalt(String raw, String salt) {
        return digest.digestAsHex(raw + salt);
    }
    
    public static boolean hashVertify(String hashed, String raw) {
        return hashVertify(hashed, raw, defaultSalt);
    }
    
    public static boolean hashVertify(String hashed, String raw, String salt) {
        return digest.digestAsHex(raw + salt).equals(hashed);
    }
    
//  public void setLoginCookie(HttpServletResponse response, String username) {
//  StringBuffer cookieValue = new StringBuffer();
//  cookieValue.append(username);
//  cookieValue.append(":");
//  cookieValue.append(String.valueOf(System.currentTimeMillis()
//          + env.getProperty("spring.cache.redis.time-to-live")));
//  cookieValue.append(":");
//  cookieValue.append(hashWithSalt(username, Constrants.Web.COOKIE_SALT));
//  
//  Cookie cookie = new Cookie(Constrants.Web.SESSION_NAME, cookieValue.toString());
//  
////  cookie.setHttpOnly(true);
////  cookie.setSecure(true);
//  cookie.setMaxAge(Integer.parseInt(env.getProperty("spring.cache.redis.time-to-live")));
//  System.out.println("SetCookie!");
//  response.addCookie(cookie);
//}
//
//public String getCookieByCookieName(HttpServletRequest request, String cookieName_) {
//  Cookie[] cookies = request.getCookies();
//  
//  //若没有Cookie将返回Null
//  if(cookies == null) {
//      return null;
//  }
//  
//  String cookieName = null;
//  String cookieValue = null;
//  
//  for(Cookie cookie : cookies) {
//      cookieName = cookie.getName();
//      if(cookieName_.equals(cookieName)) {
//          cookieValue = cookie.getValue();
//          break;
//      }
//  }       
//  return cookieValue;
//}
//
///**
//* @param request
//* @return List
//* index
//* 0 username -> String
//* 1 timeStamp -> String
//* 2 hash -> String
//*/
//public ArrayList<String> getLoginValuesByCookie(HttpServletRequest request) {
//  return getLoginValuesByCookie(request, Constrants.Web.SESSION_NAME);
//}
//
//public ArrayList<String> getLoginValuesByCookie(HttpServletRequest request, String cookieName) {
//  ArrayList<String> cookieValues = new ArrayList<String>();
//
//  String cookieValue = getCookieByCookieName(request,cookieName);
//  
//  if(cookieValue == null) {
//      return null;
//  }
//  for(String v : splitCookie(cookieValue)) {
//      cookieValues.add(v);
//  }
//  return cookieValues;
//}
    
}
