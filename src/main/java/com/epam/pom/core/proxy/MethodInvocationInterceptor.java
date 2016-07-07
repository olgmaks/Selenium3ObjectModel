package com.epam.pom.core.proxy;

import com.epam.pom.core.annotation.Action;
import com.epam.pom.core.annotation.Page;
import com.epam.pom.core.annotation.State;
import com.epam.pom.core.annotation.Step;
import com.epam.pom.core.context.AppContext;
import com.epam.pom.core.engine.Drivers;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by OLEG on 05.07.2016.
 */
public class MethodInvocationInterceptor implements MethodInterceptor {

    private Object object;


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
            throws Throwable {

        if (object == null) {
            Class clazz = obj.getClass().getSuperclass();

            boolean isPage = clazz.isAnnotationPresent(Page.class);
            boolean isAction= clazz.isAnnotationPresent(Action.class);
            boolean isState = clazz.isAnnotationPresent(State.class);

            if (isPage || isAction || isState) {
                object = clazz.newInstance();
                if (isPage) {
                    PageFactory.initElements(Drivers.get(), object);
                }
                AppContext.injector.injectMembers(object);
            }
        }

        if (method.isAnnotationPresent(Step.class)) {
            String objectLog = "Object: " + object.getClass().getSimpleName();
            String methodLog = "Method : " + method.getName();
            String argsLog = "Args : " + Arrays.toString(args);

            String totalLog = new String(objectLog + ", " + methodLog);

            if (args != null && args.length > 0) {
                totalLog += ", " + argsLog;
            }
            Reporter.log("\n" + totalLog);
        }

         return proxy.invoke(object, args);
    }
}
