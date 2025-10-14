package com.internet.pages.frames;

import com.internet.pages.BasePage;
import com.internet.pages.NestedFramesList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NestedPage extends BasePage {
    public NestedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "frame-top")
    WebElement frame_top;
    @FindBy(name = "frameset-middle")
    WebElement frameset_middle;
    @FindBy(name = "frame-left")
    WebElement frame_left;
    public NestedPage swichToNFrameLeft() {
        driver.switchTo().frame(frame_top);
        System.out.println("driver.switchTo().frame(frame_top);");
        driver.switchTo().frame(frame_left);
        System.out.println("driver.switchTo().frame(frame_left);");
        return this;
    }

    @FindBy(name = "frame-middle")
    WebElement frame_midle;
    public NestedPage swichToNFrameMiddle() {
        driver.switchTo().frame(frame_top);
        System.out.println("driver.switchTo().frame(frame_top);");
        driver.switchTo().frame(frame_midle);
        System.out.println("driver.switchTo().frame(frame_midle);");
        return this;
    }

    @FindBy(name = "frame-right")
    WebElement frame_right;
    public NestedPage swichToNFrameRight() {
        driver.switchTo().frame(frame_top);
        System.out.println("driver.switchTo().frame(frame_top);");
        driver.switchTo().frame(frame_right);
        System.out.println("driver.switchTo().frame(frame_right);");
        return this;
    }

    @FindBy(name = "frame-bottom")
    WebElement frame_bottom;
    public NestedPage swichToNFrameBottom() {
        driver.switchTo().frame(frame_bottom);
        System.out.println("driver.switchTo().frame(frame_bottom);");
        return this;
    }



    @FindBy(xpath = "//body")
    WebElement left;
    public NestedPage verifyNFrameLeft() {
        Assert.assertEquals(left.getText(), NestedFramesList.LEFT_FRAME);
        return this;
    }
    @FindBy(xpath = "//body//div[@id='content']")
    WebElement middle;
    public NestedPage verifyNFrameMiddle() {
        Assert.assertEquals(middle.getText(), NestedFramesList.MIDDLE_FRAME);
        return this;
    }
    @FindBy(xpath = "//body")
    WebElement right;
    public NestedPage verifyNFrameRight() {
        Assert.assertEquals(right.getText(), NestedFramesList.RIGHT_FRAME);
        return this;
    }

    @FindBy(xpath = "//body")
    WebElement bottom;
    public NestedPage verifyNFrameBottom() {
        Assert.assertEquals(bottom.getText(), NestedFramesList.BOTTOM_FRAME);
        return this;
    }
}
