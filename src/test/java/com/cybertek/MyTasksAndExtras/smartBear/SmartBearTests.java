package com.cybertek.MyTasksAndExtras.smartBear;

import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    WebDriver driver;

    @BeforeMethod
    public void logInSetUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test(priority = 1)
    public void verifyLinkTC1() {
        SmartBearUtils.loginToSmartBear(driver);
        SmartBearUtils.tc1verifyLink(driver);
    }

    @Test(priority = 2)
    public void orderPlacingTC2() throws InterruptedException {
        SmartBearUtils.loginToSmartBear(driver);
        SmartBearUtils.tc2orderPlacing(driver);
    }

    @Test(priority = 3)
    public void orderVerificationTC3(){
        SmartBearUtils.loginToSmartBear(driver);
        SmartBearUtils.tc3orderVerification(driver);
    }

    @Test(priority = 4)
    public void verifyOrderTC4() {
        SmartBearUtils.loginToSmartBear(driver);
        SmartBearUtils.tc4verifyOrder(driver, "Mark Smith");
    }

    @Test(priority = 5)
    public void nameAndCityTestTC5(){
        SmartBearUtils.loginToSmartBear(driver);
        SmartBearUtils.tc5printNamesAndCities(driver);
    }

    @AfterMethod
    public void endOfTest() {
        driver.quit();

    }
}
