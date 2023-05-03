package cn.auto.designer.beans.factory;

import cn.auto.designer.beans.BeansException;

public interface BeanFactory
{
    Object getBean(String beanName)
            throws BeansException;

    Boolean containsBean(String name);

    void registerBean(String beanName, Object obj);
}
