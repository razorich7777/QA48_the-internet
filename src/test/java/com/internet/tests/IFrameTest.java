package com.internet.tests;

import com.internet.pages.FramesPage;
import com.internet.pages.HomePage;
import com.internet.pages.frames.IFramePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).clickOnIFrameLink();
        new FramesPage(driver).clickOnIFrame();
    }

    @Test
    public void IFrameTestPositive(){
        String text = "Some text";
        new IFramePage(driver)
                .clickOnCloseAlert()
                .swichToIFrame()
                .ChangeScriptLock()
                .fillIFrame(text)
                .verifyIFrame(text);
    }
}
