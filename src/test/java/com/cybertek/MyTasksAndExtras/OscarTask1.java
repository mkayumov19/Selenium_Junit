package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OscarTask1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(" http://thedemosite.co.uk/login.php");
    }

    @Test
    public void test1(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login example page to test the PHP MySQL online system";
        Assert.assertEquals(actualTitle, expectedTitle);
//      Assert.assertTrue(actualTitle.equals(expectedTitle));
        System.out.println("Test Pass! Webpage is open and Titles match! ");
        String actualHeader = driver.findElement(By.xpath("//td[@class='auto-style1']//p/big[.='4. Login']")).getText();
        String expectedHeader = "4. Login";
        Assert.assertEquals(actualHeader, expectedHeader);
        System.out.println("Test Pass! Headers match! ");
        String actualStatusMessage = driver.findElement(By.xpath("//font[@color='#ff8000']//b")).getText();
        String expectedStatusMessage = "**No login attempted**";
        Assert.assertEquals(actualStatusMessage, expectedStatusMessage);
        System.out.println("Test Pass! Status message match! ");
        String actualInfoMess = driver.findElement(By.xpath("//blockquote//p[@align='center']")).getText();
        String expectedInfoMess = "Enter your login details you added on the previous page and test the login.\nThe success or failure will be shown above.";
        Assert.assertEquals(actualInfoMess, expectedInfoMess);


    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
