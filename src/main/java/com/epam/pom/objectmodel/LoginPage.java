package com.epam.pom.objectmodel;

import com.epam.pom.core.annotation.Page;
import com.epam.pom.core.engine.Drivers;
import com.google.inject.Inject;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by OLEG on 05.07.2016.
 */
@Page
public class LoginPage {


    @FindBy(id = "Email")
    @Getter
    private WebElement loginTextField;




}
