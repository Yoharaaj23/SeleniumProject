package com.test.yoharaaj.pages;

import com.test.yoharaaj.helpers.PageObjectLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class OrderPage extends Common {
    private static final By tshirtSection = PageObjectLoader.getPageObject("order.tshirt.css");
    private static final By tshirtHeading = PageObjectLoader.getPageObject("order.tshirt.heading.css");
    private static final By selectFirstItem = PageObjectLoader.getPageObject("order.firstItem.xpath");
    private static final By addToCart = PageObjectLoader.getPageObject("order.addCart.xpath");
    private static final By addedSuccess = PageObjectLoader.getPageObject("order.tshirt.added.css");
    private static final By summaryCheckout = PageObjectLoader.getPageObject("order.proceed.button.xpath");
    private static final By itemPrice = PageObjectLoader.getPageObject("order.summary.itemPrice.css");
    private static final By proceedAddress = PageObjectLoader.getPageObject("order.summary.proceed.css");
    private static final By proceedShipping = PageObjectLoader.getPageObject("order.address.proceed.css");
    private static final By termsCheckbox = PageObjectLoader.getPageObject("order.terms.agree.checkbox.xpath");
    private static final By proceedPayment = PageObjectLoader.getPageObject("order.shipping.proceed.css");
    private static final By bankWire = PageObjectLoader.getPageObject("order.payment.bankwire.css");
    private static final By confirmOrder = PageObjectLoader.getPageObject("order.confirm.order.css");
    private static final By orderComplete = PageObjectLoader.getPageObject("order.complete.text.css");
    private static final By backToOrder = PageObjectLoader.getPageObject("order.backToOrder.css");
    private static final By orderSummary = PageObjectLoader.getPageObject("order.history.orderSummary.xpath");
    private static final By orderNumber = PageObjectLoader.getPageObject("order.history.orderNumber.xpath");


    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Boolean isTshirtSectionVisible() {
        waitUntilLoaded(tshirtHeading);
        return driver.findElement(tshirtHeading).isDisplayed();
    }

    public void clickTshirtSection() {
        waitUntilLoaded(tshirtSection);
        driver.findElement(tshirtSection).click();
    }

    public void addFirstItemToCart() {
        waitUntilClickable(selectFirstItem);
        driver.findElement(selectFirstItem).click();
        waitUntilLoaded(addToCart);
        driver.findElement(addToCart).click();
    }

    public Boolean isItemAdded() {
        waitUntilLoaded(addedSuccess);
        return driver.findElement(addedSuccess).getText().trim().equals("Product successfully added to your shopping cart");
    }

    public void clickSummaryCheckout() {
        waitUntilLoaded(summaryCheckout);
        driver.findElement(summaryCheckout).click();
    }

    public Boolean verifyItemPrice(String price) {
        waitUntilLoaded(itemPrice);
        return driver.findElement(itemPrice).getText().trim().equals(price);
    }

    public void proceedToAddress() {
        waitUntilClickable(proceedAddress);
        driver.findElement(proceedAddress).click();
    }

    public boolean proceedToShipping() {
        waitUntilClickable(proceedShipping);
        driver.findElement(proceedShipping).click();
        WebElement checkBox = driver.findElement(termsCheckbox);
        checkBox.click();
        return checkBox.isSelected();
    }

    public void proceedToPayment() {
        waitUntilClickable(proceedPayment);
        driver.findElement(proceedPayment).click();
    }

    public void confirmOrder() {
        waitUntilClickable(bankWire);
        driver.findElement(bankWire).click();
        waitUntilClickable(confirmOrder);
        driver.findElement(confirmOrder).click();
    }

    public Boolean isOrderComplete() {
        waitUntilLoaded(orderComplete);
        return driver.findElement(orderComplete).getText().trim().equals("Your order on My Store is complete.");
    }

    public boolean verifyOrderHistory() {
        String summary = driver.findElement(orderSummary).getText().trim();
        int i = summary.indexOf("reference");
        String orderRef = summary.substring(i + 10, i + 19);
        waitUntilClickable(backToOrder);
        driver.findElement(backToOrder).click();
        return driver.findElement(orderNumber).getText().trim().equals(orderRef);
    }

}
