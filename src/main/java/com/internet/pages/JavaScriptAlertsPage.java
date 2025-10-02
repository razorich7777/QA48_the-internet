package com.internet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class JavaScriptAlertsPage extends BasePage{
    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[contains(text(), 'Click for JS Alert')]")
    WebElement AlertButton;
    public JavaScriptAlertsPage alertAccept() {
        click(AlertButton);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent())
                .accept();
        return this;
    }
    @FindBy(xpath = "//*[contains(text(), 'Click for JS Confirm')]")
    WebElement AlertButtonConfirmOk;
    public JavaScriptAlertsPage alertAcceptConfirmOk() {
        click(AlertButtonConfirmOk);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent())
                .accept();
        return this;
    }
    @FindBy(xpath = "//*[contains(text(), 'Click for JS Confirm')]")
    WebElement AlertButtonConfirmCancel;
    public JavaScriptAlertsPage alertAcceptConfirmCancel() {
        click(AlertButtonConfirmCancel);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent())
                .dismiss();
        return this;
    }

    @FindBy(xpath = "//*[contains(text(), 'Click for JS Prompt')]")
    WebElement AlertPrompt;
    String prompt = "start";
    public JavaScriptAlertsPage alertAcceptPrompt() {
        click(AlertPrompt);
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(prompt);
        alert.accept();
        return this;
    }


    @FindBy(id = "result")
    WebElement AlertText;

    public JavaScriptAlertsPage verifyAlertOkPositive() {
        Assert.assertEquals(AlertText.getText(), "You successfully clicked an alert");
        return this;
    }


    public JavaScriptAlertsPage verifyAlertConfirmOkPositive() {
        Assert.assertEquals(AlertText.getText(), "You clicked: Ok");
        return this;
    }


    public JavaScriptAlertsPage verifyAlertConfirmCancelPositive() {
        Assert.assertEquals(AlertText.getText(), "You clicked: Cancel");
        return this;
    }

    public JavaScriptAlertsPage verifyAlertPromptPositive() {
        String res = "You entered: " + prompt;
        Assert.assertEquals(AlertText.getText(), res);
        return this;
    }
}
//You successfully clicked an alert