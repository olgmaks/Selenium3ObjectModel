package com.epam.pom.core.proxy;

import com.epam.pom.core.annotation.Action;
import com.epam.pom.core.annotation.Component;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Field;

/**
 * Created by OLEG on 05.07.2016.
 */
public class ProxyController {


    public void attachProxy(Object obj) throws IllegalAccessException {


        Field[] fields = obj.getClass().getDeclaredFields();


        for (Field field : fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(Component.class)) {

                if (field.get(obj) == null) {
                    field.set(obj, Enhancer.create(field.getType(),
                            new MethodInvocationInterceptor()));
                }
            }
        }
    }
}
