package com.cybertek.MyTasksAndExtras.smartBear;

import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearLinkVerify {

    WebDriver driver;

    @BeforeMethod
    public void logInSetUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void logIn() {
        SmartBearUtils.loginToSmartBear(driver);
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        int linksSize = listOfLinks.size();
        System.out.println("Count of links on page: " + linksSize);
        int num = 1;
        for (WebElement eachLink : listOfLinks) {
            System.out.println("Link:" + num++ + " - " + eachLink.getText());

        }

    }

    @AfterMethod
    public void endOfTest() {
        driver.quit();

    }

}
