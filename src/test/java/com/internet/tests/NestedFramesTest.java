package com.internet.tests;


import com.internet.pages.FramesPage;
import com.internet.pages.HomePage;
import com.internet.pages.frames.NestedPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).clickOnIFrameLink();
        new FramesPage(driver).clickOnNestedFrame();
    }


    @Test
    public void NestedFrameTestPositiveLeft(){
        String text = "Some text";
        new NestedPage(driver)
                .swichToNFrameLeft()
                .verifyNFrameLeft();

    }
    @Test
    public void NestedFrameTestPositiveMiddle(){
        String text = "Some text";
        new NestedPage(driver)
                .swichToNFrameMiddle()
                .verifyNFrameMiddle();

    }
    @Test
    public void NestedFrameTestPositiveRight(){
        String text = "Some text";
        new NestedPage(driver)
                .swichToNFrameRight()
                .verifyNFrameRight();
    }

    @Test
    public void NestedFrameTestPositiveBottom(){
        String text = "Some text";
        new NestedPage(driver)
                .swichToNFrameBottom()
                .verifyNFrameBottom();
    }

}
