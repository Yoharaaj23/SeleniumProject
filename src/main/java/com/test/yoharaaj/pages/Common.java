package com.test.yoharaaj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

    protected WebDriver driver;

    Common(WebDriver driver) {
        this.driver = driver;
    }

    public  ExpectedCondition getPageLoadCondition(By element){
        return ExpectedConditions.visibilityOf(driver.findElement(element));
    }
    public  ExpectedCondition getFieldClickableCondition(By element){
        return ExpectedConditions.visibilityOf(driver.findElement(element));
    }

    public void waitUntilLoaded(By element) {
        int timeOut = 5;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(getPageLoadCondition(element));
    }
    public void waitUntilClickable(By element) {
        int timeOut = 5;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(getFieldClickableCondition(element));
    }

}