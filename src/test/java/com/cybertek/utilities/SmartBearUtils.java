package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SmartBearUtils {

//    public static void openSmartBearLink(WebDriver driver){
//        driver = WebDriverFactory.getDriver("chrome");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//    }

    public static void loginToSmartBear(WebDriver driver) {
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        login.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
    }

    public static void verifyOrder(WebDriver driver, String name) {
        List<String> actualProduct = new ArrayList<>();
        List<WebElement> orders = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[3]"));
        for (WebElement temp : orders) {
            actualProduct.add(temp.getText());
        }
        Assert.assertTrue(actualProduct.contains(name));
    }

    public static void printNamesAndCities(WebDriver driver) {
        List<String> names = new ArrayList<>();
        List<String> cities = new ArrayList<>();
        List<WebElement> webNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));
        List<WebElement> webCities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[7]"));
        for (WebElement eachName : webNames) {
            names.add(eachName.getText());
        }
        for (WebElement eachCity : webCities) {
            cities.add(eachCity.getText());
        }
        int num = 1;
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Name"+ num + ": " + names.get(i) + ", \t\tCity"+ num +": " + cities.get(i));
            num++;
        }
    }
}
