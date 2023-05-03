package cn.auto.designer.beans.factory.xml;

import cn.auto.designer.beans.BeanDefinition;
import cn.auto.designer.beans.factory.BeanFactory;
import cn.auto.designer.core.Resource;
import org.dom4j.Element;

public class XmlBeanDefinitionReader
{
    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory)
    {
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinitions(Resource resource)
    {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
