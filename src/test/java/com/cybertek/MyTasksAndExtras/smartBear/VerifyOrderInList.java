package com.cybertek.MyTasksAndExtras.smartBear;

import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyOrderInList {

    WebDriver driver;

    @BeforeMethod
    public void orderVerifySetUp() {
//  SmartBearUtils.openSmartBearLink(driver);
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void verifyOrderInList() {
        SmartBearUtils.loginToSmartBear(driver);
        SmartBearUtils.verifyOrder(driver, "Mark Smith");

    }

}
