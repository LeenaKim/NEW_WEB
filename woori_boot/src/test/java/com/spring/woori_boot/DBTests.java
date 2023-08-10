package com.spring.woori_boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class DBTests {

    @Autowired
    private ApplicationContext context;
    
    @Test
    public void testByApplicationContext() {
        try{
            System.out.println("====================");
            System.out.println(context.getBean("mariaFactory"));
            System.out.println("====================");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
