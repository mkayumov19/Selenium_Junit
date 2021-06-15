package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC5NonSelectDD {
    /**
     * TC #5: Selecting value from non-select dropdown
     * 1. Open Chrome browser
     * 2. Go to http://practice.cybertekschool.com/dropdown
     * 3. Click to non-select dropdown
     * 4. Select Facebook from dropdown
     * 5. Verify title is “Facebook - Log In or Sign Up”
     */

        @Test
        public void nonSelectDropDown() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement nonSelectLocator = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        nonSelectLocator.click();
        WebElement facebook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        facebook.click();
        //get facebook title to check
        String expected = "Facebook - Log In or Sign Up";
        String actual = driver.getTitle();
        Assert.assertEquals(expected, actual);
        System.out.println("Actual title: " + actual);
        System.out.println("Expected title: " + expected);
    }
}
