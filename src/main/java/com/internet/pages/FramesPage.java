package com.internet.pages;

import com.internet.pages.frames.IFramePage;
import com.internet.pages.frames.NestedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage{

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='/iframe']")
    WebElement iframe;

    public IFramePage clickOnIFrame() {
        click(iframe);

        return new IFramePage(driver);
    }

    @FindBy(css = "[href='/nested_frames']")
    WebElement nframe;

    public NestedPage clickOnNestedFrame() {
        click(nframe);
        return new NestedPage(driver);
    }
}
