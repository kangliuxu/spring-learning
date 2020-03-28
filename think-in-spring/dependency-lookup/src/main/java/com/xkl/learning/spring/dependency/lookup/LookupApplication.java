package com.xkl.learning.spring.dependency.lookup;

import com.xkl.learning.spring.dependency.lookup.annotation.Super;
import com.xkl.learning.spring.dependency.lookup.bean.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author xkl
 * @date 2020/3/28
 * @description
 * 实践 按名称查找 实时与延迟
 * 按类型查找
 * 按注解查找
 * 集合查找
 **/
public class LookupApplication {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/lookup-beanfactory.xml");
//        lookupByName(beanFactory);
//        lookupByNameLazy(beanFactory);
        lookupByType(beanFactory);
        lookupByTypeLists(beanFactory);
        lookupByAnnotation(beanFactory);
    }

    public static void lookupByName( BeanFactory beanFactory){
        final User user = beanFactory.getBean("user", User.class);
        System.out.println("实时查找:"+user);
    }

    public static void lookupByNameLazy(BeanFactory beanFactory){
        final ObjectFactory<User> obejctFactory = beanFactory.getBean("objectFactory", ObjectFactory.class);
        final User user = obejctFactory.getObject();
        System.out.println("延迟查找:"+user);
    }

    public static void lookupByType( BeanFactory beanFactory){
        final User user = beanFactory.getBean(User.class);
        System.out.println("类型查找:"+user);
    }

    public static void lookupByTypeLists(BeanFactory beanFactory){
        final ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        final Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
        System.out.println("根据类型查找集合:"+beansOfType);
    }

    public static void lookupByAnnotation(BeanFactory beanFactory){
        final ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        final Map<String, Object> beans = listableBeanFactory.getBeansWithAnnotation(Super.class);
        System.out.println("根据注解查找集合:"+beans);

    }

}
