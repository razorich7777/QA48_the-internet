package com.internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='/javascript_alerts']")
    WebElement link;

    public JavaScriptAlertsPage clickOnJavaScriptAlerts(){
        click(link);
        return new JavaScriptAlertsPage(driver);
    }

    @FindBy(css = "[href='/frames']")
    WebElement frames;

    public FramesPage clickOnIFrameLink() {
        click(frames);
        return new FramesPage(driver);
    }
}
