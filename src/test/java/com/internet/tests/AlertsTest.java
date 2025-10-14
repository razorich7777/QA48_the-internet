package com.internet.tests;

import com.internet.pages.HomePage;
import com.internet.pages.JavaScriptAlertsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends TestBase{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).clickOnJavaScriptAlerts();
    }

    @Test
    public void alertTestPositive(){
        new JavaScriptAlertsPage(driver)
                .alertAccept()
                .verifyAlertOkPositive();
    }
    @Test
    public void alertTestConfirmOkPositive(){
        new JavaScriptAlertsPage(driver)
                .alertAcceptConfirmOk()
                .verifyAlertConfirmOkPositive();
    }
    @Test
    public void alertTestConfirmCancelPositive(){
        new JavaScriptAlertsPage(driver)
                .alertAcceptConfirmCancel()
                .verifyAlertConfirmCancelPositive();
    }
    @Test
    public void alertTestPromptPositive(){
        new JavaScriptAlertsPage(driver)
                .alertAcceptPrompt()
                .verifyAlertPromptPositive();
    }



}
