package com.ffssabcloud.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author fssaw
 *
 */
@EnableTransactionManagement
@SpringBootApplication
public class Application 
{
    public static void main(String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
}
