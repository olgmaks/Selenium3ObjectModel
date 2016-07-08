package com.epam.pom.core.context;

import com.epam.pom.action.LoginAction;
import com.epam.pom.core.proxy.MethodInvocationInterceptor;
import com.epam.pom.objectmodel.LoginPage;
import com.epam.pom.objectmodel.PasswordPage;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by OLEG on 08.07.2016.
 */
public class AppContext {



    // TODO create custom injector for class
   public static final Injector injector = Guice.createInjector(new AbstractModule() {
       
        @Override
        protected void configure() {
            Class[] classes = {
                    PasswordPage.class,
                    LoginAction.class,
                    LoginPage.class
            };

            for (Class clazz : classes) {
                bind(clazz).toInstance(EnhanceProxyObject(clazz));
            }
        }

        private <T> T EnhanceProxyObject(Class<T> clazz) {
            return (T) Enhancer.create(
                    clazz, new MethodInvocationInterceptor()
             );
        }
    });
}
