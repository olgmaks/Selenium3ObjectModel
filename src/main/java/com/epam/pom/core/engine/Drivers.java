package com.epam.pom.core.engine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by OLEG on 05.07.2016.
 */
public class Drivers {

    private static WebDriver webDriver;

    private Drivers() {}

    public static WebDriver get() {

        if (webDriver != null)
            return webDriver;

        else {
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return webDriver;
        }
    }





}
