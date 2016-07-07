package com.epam.pom;

import com.epam.pom.action.LoginAction;
import com.epam.pom.core.annotation.Component;
import com.epam.pom.core.engine.Drivers;

import com.epam.pom.core.listener.ComponentListener;
import com.epam.pom.core.proxy.MethodInvocationInterceptor;
import com.epam.pom.objectmodel.LoginPage;
import com.epam.pom.objectmodel.PasswordPage;
import com.google.inject.*;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.reflect.ConstructorDelegate;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;


/**
 * Created by OLEG on 05.07.2016.
 */

@Listeners(ComponentListener.class)
public class TestClass {

    @Inject
    private LoginAction loginAction;





    @Test
    public void loginTest() throws IllegalAccessException, NoSuchFieldException {


//        injector.injectMembers(this);

        Drivers.get().navigate().to(
                "https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=uk&businesslogic=mail#identifier");

        loginAction.setLogin("roy.gibson.junior@gmail.com");
        loginAction.submitLogin();
        loginAction.setPassword("gibsonsmith2009");
        loginAction.submitPassword();

        Drivers.get().quit();
//        ConstructorDelegate.create(LoginAction.class,)

//

//


    }
}
