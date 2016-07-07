package com.epam.pom.action;

import com.epam.pom.core.annotation.Action;
import com.epam.pom.core.annotation.Component;
import com.epam.pom.core.annotation.Page;
import com.epam.pom.core.annotation.Step;
import com.epam.pom.objectmodel.LoginPage;
import com.epam.pom.objectmodel.PasswordPage;
import com.google.inject.Inject;

/**
 * Created by OLEG on 05.07.2016.
 */
@Action
public class LoginAction {

    @Inject
    private LoginPage loginPage;

    @Inject
    private PasswordPage passwordPage;


    @Step
    public void setLogin(String login) {
        loginPage.getLoginTextField().sendKeys(login);
    }

    @Step
    public void setPassword(String password) {
        passwordPage.getPasswordTextField().sendKeys(password);
    }

    @Step
    public void submitLogin() {
        loginPage.getLoginTextField().submit();
    }

    @Step
    public void submitPassword() {
        passwordPage.getPasswordTextField().submit();
    }
}
