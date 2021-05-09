package com.test.yoharaaj.pages;

import com.test.yoharaaj.helpers.PageObjectLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Common{
    private static final By emailID = PageObjectLoader.getPageObject("login.email.id");
    private static final By password = PageObjectLoader.getPageObject("login.password.id");
    private static final By signIn = PageObjectLoader.getPageObject("login.signIn.id");
    private static final By pageHeading = PageObjectLoader.getPageObject("account.pageHeading.css");
    private static final By myAccount = PageObjectLoader.getPageObject("home.myAccount.css");

    private static final By personalInfo = PageObjectLoader.getPageObject("account.personal.info.css");
    private static final By firstName =  PageObjectLoader.getPageObject("account.firstname.id");
    private static final By passwd =  PageObjectLoader.getPageObject("account.old_password.id");
    private static final By saveButton =  PageObjectLoader.getPageObject("account.save.css");
    private static final By saveAlertSuccess =  PageObjectLoader.getPageObject("account.save.alert.success.xpath");
    private static final String emailAddress = "Tester23testing@gmail.com";
    private static final String passwordText = "Automation#123";
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public Boolean isMyAccountVisible() {
        waitUntilLoaded(pageHeading);
        return driver.findElement(pageHeading).isDisplayed();
    }
    public Boolean signIn(){
        driver.findElement(emailID).sendKeys(emailAddress);
        driver.findElement(password).sendKeys(passwordText);
        driver.findElement(signIn).click();
        return isMyAccountVisible();
        }

    public void clickMyPersonalInfo(){
        waitUntilLoaded(myAccount);
        driver.findElement(personalInfo).click();
    }
    public void updateFirstName(String firstname){
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(passwd).sendKeys(passwordText);
        waitUntilClickable(saveButton);
        driver.findElement(saveButton).click();
    }
    public boolean isUpdateSuccess(){
        return driver.findElement(saveAlertSuccess).getText().trim().equals("Your personal information has been successfully updated.");
    }
}
