package com.test.yoharaaj.helpers;

import org.openqa.selenium.By;

public class PageObjectLoader {
    public static By getPageObject(String propertyKey) {

        By returnByType = null;
        try {
            String propertyValue = PropertyReader.getProperty(propertyKey);
            String[] arrayVals = propertyKey.split("\\.");
            String identityType = arrayVals[arrayVals.length - 1];
            if (identityType.equalsIgnoreCase("name")) {
                returnByType = By.name(propertyValue);
            } else if (identityType.equalsIgnoreCase("id")) {
                returnByType = By.id(propertyValue);
            } else if (identityType.equalsIgnoreCase("css")) {
                returnByType = By.cssSelector(propertyValue);
            } else if (identityType.equalsIgnoreCase("linktext")) {
                returnByType = By.linkText(propertyValue);
            } else if (identityType.equalsIgnoreCase("xpath")) {
                returnByType = By.xpath(propertyValue);
            }
            return returnByType;
        } catch (final Exception e) {

            e.printStackTrace();

        }
        return returnByType;
    }
}
