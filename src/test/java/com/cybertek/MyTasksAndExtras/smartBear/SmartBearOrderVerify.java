package com.cybertek.MyTasksAndExtras.smartBear;

import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearOrderVerify {

    WebDriver driver;

    @BeforeMethod
    public void orderVerifySetUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @Test
    public void orderVerify() {
        SmartBearUtils.loginToSmartBear(driver);
        driver.findElement(By.xpath("//a[.='View all orders']")).click();
        String customer = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[.='Susan McLaren']")).getText();
        System.out.println("Customer name: " + customer);
        String actualOrderDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[.='01/05/2010']")).getText();
        System.out.println("Actual order date: " + actualOrderDate);
        String expectedOrderDate = "01/05/2010";
        Assert.assertEquals(actualOrderDate,expectedOrderDate);

    }

    public static class NamesAndCitiesSmartBear {

        WebDriver driver;

        @BeforeMethod
        public void nameAndCitySetUp() {
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        }

        @Test
        public void nameAndCityTest(){
            SmartBearUtils.loginToSmartBear(driver);
            SmartBearUtils.printNamesAndCities(driver);
        }
    }
}
