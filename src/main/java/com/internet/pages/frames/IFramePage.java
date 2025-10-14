package com.internet.pages.frames;

import com.internet.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class IFramePage extends BasePage {


    public IFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".tox-notification__dismiss")
    WebElement tox_notification__dismiss;

    public IFramePage clickOnCloseAlert(){
        click(tox_notification__dismiss);
        return this;
    }

    public IFramePage ChangeScriptLock() {

        js.executeScript("document.getElementById('tinymce').setAttribute('contenteditable', 'true');");

        return this;
    }
    @FindBy(id = "mce_0_ifr")
    WebElement frame;

    public IFramePage swichToIFrame() {
        driver.switchTo().frame(frame);
        return this;
    }

    @FindBy(id = "tinymce")
    WebElement body;
    //tinymce
    public IFramePage fillIFrame(String text) {
        fill(body, text);
        return this;
    }

    @FindBy(id = "tinymce")
    WebElement bodyChanged;

    public IFramePage verifyIFrame(String text) {

        Assert.assertEquals(bodyChanged.getText(),text);
        return this;
    }
}
