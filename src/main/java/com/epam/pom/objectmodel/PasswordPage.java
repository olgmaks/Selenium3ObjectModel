package com.epam.pom.objectmodel;

import com.epam.pom.core.annotation.Page;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by OLEG on 06.07.2016.
 */
@Page
public class PasswordPage {


    @FindBy(id = "Passwd")
    @Getter
    private WebElement passwordTextField;


}
