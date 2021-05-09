package com.test.yoharaaj.pages;

import com.test.yoharaaj.helpers.PageObjectLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends Common {

    private static final By websiteLogo = PageObjectLoader.getPageObject("home.webSiteLogo.id");
    private static final By signIn = PageObjectLoader.getPageObject("home.sign.css");
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean isLogoVisible() {
        waitUntilLoaded(websiteLogo);
        return driver.findElement(websiteLogo).isDisplayed();
    }
    private Boolean isSignInVisible() {
        waitUntilLoaded(signIn);
        return driver.findElement(signIn).isDisplayed();
    }
    public Boolean clickSign(){
        waitUntilLoaded(signIn);
        driver.findElement(signIn).click();
        return isSignInVisible();
    }

}