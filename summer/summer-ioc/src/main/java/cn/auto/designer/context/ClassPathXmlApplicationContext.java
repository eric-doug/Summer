package cn.auto.designer.context;

import cn.auto.designer.beans.BeanDefinition;
import cn.auto.designer.beans.BeansException;
import cn.auto.designer.beans.factory.BeanFactory;
import cn.auto.designer.beans.factory.SimpleBeanFactory;
import cn.auto.designer.beans.factory.xml.XmlBeanDefinitionReader;
import cn.auto.designer.core.ClassPathXmlResource;
import cn.auto.designer.core.Resource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext
{
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName)
    {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    /**
     * 这是对外的一个方法，让外部程序从容器中获取Bean实例，会逐步演化成核心方法
     *
     * @param beanName
     * @return
     */
    public Object getBean(String beanName)
            throws BeansException
    {
        return this.beanFactory.getBean(beanName);
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition)
    {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}
