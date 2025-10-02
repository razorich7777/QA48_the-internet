package com.internet.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement link) {
        link.click();
    }

    public void type(WebElement element, String text){
        if(text!=null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }
}
