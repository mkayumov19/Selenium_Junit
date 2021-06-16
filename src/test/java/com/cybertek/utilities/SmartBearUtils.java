package com.cybertek.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SmartBearUtils {

//      WebDriver driver;

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

    public static void tc1verifyLink(WebDriver driver) {
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        int linksSize = listOfLinks.size();
        System.out.println("Count of links on page: " + linksSize);
        int num = 1;
        for (WebElement eachLink : listOfLinks) {
            System.out.println("Link:" + num++ + " - " + eachLink.getText());
        }
    }

    public static void tc2orderPlacing(WebDriver driver) {
        driver.findElement(By.xpath("//a[.='Order']")).click();
        WebElement productList = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select select = new Select(productList);
        select.selectByVisibleText("FamilyAlbum");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(name+" "+ lastName);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(faker.address().zipCode().substring(0,5));
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys
                (faker.finance().creditCard().replace("-",""));
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys("02/26");
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();
        String actualConfirmation = driver.findElement(By.xpath("//div//strong")).getText();
        String expectedConfirmation = "New order has been successfully added.";
        Assert.assertEquals(actualConfirmation, expectedConfirmation);
        System.out.println("Test 2 Passed");

    }

    public static void tc3orderVerification(WebDriver driver) {
        driver.findElement(By.xpath("//a[.='View all orders']")).click();
        String customer = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[.='Susan McLaren']")).getText();
        System.out.println("Customer name: " + customer);
        String actualOrderDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[.='01/05/2010']")).getText();
        System.out.println("Actual order date: " + actualOrderDate);
        String expectedOrderDate = "01/05/2010";
        Assert.assertEquals(actualOrderDate,expectedOrderDate);

    }

    public static void tc4verifyOrder(WebDriver driver, String name) {
        List<String> actualProduct = new ArrayList<>();
        List<WebElement> orders = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));
        for (WebElement temp : orders) {
            actualProduct.add(temp.getText());
        }
        Assert.assertTrue(actualProduct.contains(name));
        System.out.println("List of names: " + actualProduct);
        System.out.println("Expected name within list: " + name);
    }

    public static void tc5printNamesAndCities(WebDriver driver) {
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
