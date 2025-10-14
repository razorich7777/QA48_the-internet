package com.internet.tests;

import com.internet.pages.BasePage;
import com.internet.pages.util.Listener2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

public class TestBase {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite
    public void init(){
        driver = new ChromeDriver();
        WebDriverListener listener = new Listener2();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        driver.get("https://the-internet.herokuapp.com/");
        logger.info("Current url --> " + driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] p){
        driver.get("https://the-internet.herokuapp.com/");
        logger.info("Start test " + method.getName() + Arrays.asList(p));
    }

    @AfterMethod
    public void afterTest(ITestResult result){
        if (result.isSuccess()){
            logger.info("PASSED: " + result.getMethod().getMethodName());
        }
        else {
            logger.error("FAILED: "  + result.getMethod().getMethodName() );
        }
        logger.info("Finish test");
        logger.info("*************************************");
    }
}

