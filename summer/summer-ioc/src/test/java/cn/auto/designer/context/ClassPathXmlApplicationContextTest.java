package cn.auto.designer.context;

import cn.auto.designer.beans.BeansException;
import cn.auto.designer.ioc.AService;
import org.junit.Test;

class ClassPathXmlApplicationContextTest
{

    @Test
    void getBean()
    {
        System.out.println("test");
    }

    @Test
    public void testHello()
    {
        System.out.println("hello");
    }

    public static void main(String[] args)
            throws BeansException
    {
        System.out.println("test");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        AService aService = (AService) ctx.getBean("aservice");
        aService.sayHello();
    }
}