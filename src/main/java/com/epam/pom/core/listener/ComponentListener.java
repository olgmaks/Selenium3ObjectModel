package com.epam.pom.core.listener;

import com.epam.pom.action.LoginAction;
import com.epam.pom.core.context.AppContext;
import com.epam.pom.core.proxy.MethodInvocationInterceptor;
import com.epam.pom.core.proxy.ProxyController;
import com.epam.pom.objectmodel.LoginPage;
import com.epam.pom.objectmodel.PasswordPage;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import net.sf.cglib.proxy.Enhancer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

/**
 * Created by OLEG on 06.07.2016.
 */
public class ComponentListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {


        try {
            Field field = iTestResult.getClass().getDeclaredField("m_instance");
            field.setAccessible(true);
            Object o = field.get(iTestResult);
            AppContext.injector.injectMembers(o);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(iTestResult);

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
