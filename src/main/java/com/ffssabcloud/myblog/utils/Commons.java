package com.ffssabcloud.myblog.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.Article;

/**
 * 公共函数
 * @author fssaw
 *
 */
@Component
public class Commons {
    
    public String random(int max, String suffix) {
        Random random = new Random();
        return (random.nextInt(max-1+1) + 1) + suffix;
    }
    
    public String fmtUnixTime(int time, String pattern) {
        SimpleDateFormat sdfm = new SimpleDateFormat(pattern);
        return sdfm.format(new Date(time * 1000L));
    }
    
    public String fmtUnixTime(int time) {
        return fmtUnixTime(time, "yyyy-MM-dd");
    }
    
    public <T> Set<T> removeListRepetition(List<T> list) {
        return new HashSet<T>(list);
    }
    
    public Set<String> removeStrRepetition(List<Article> list) {
        Set<String> set = new HashSet<String>();
        for(Article article : list) {
            set.add(article.getCategories());
        }
        return set;
    }
    
    public String getRequestUri(HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        return request.getRequestURI() + "/";
    }
    
    public class NoRepeatPreRandomPicker<T> {
        
        private List<T> container;
        private int size;
        private Random rand = new Random();
        private T previous = null;
        
        NoRepeatPreRandomPicker(List<T> container) {
            this.container = container;
            this.size = container.size();
        }
        
        public T getPrevious() {
            return previous;
        }
        
        public void setPrevious(T previous) {
            this.previous = previous;
        }
        
        public List<T> getContainer() {
            return container;
        }
        
        public void setContainer(List<T> container) {
            this.container = container;
        }
        
        public T random() {
            T temp = null;
            
            if(this.size == 0) {
                return null;
            }
            if(this.size == 1) {
                return this.container.get(0);
            }
            
            while(true) {
                if(this.previous == null) {
                    this.previous = this.container.get(this.rand.nextInt(this.size));
                }
                temp = this.container.get(this.rand.nextInt(this.size));
                if(!this.previous.equals(temp)) {
                    this.previous = temp;
                    return temp;
                }
            }
            
        }
        
    }
}
