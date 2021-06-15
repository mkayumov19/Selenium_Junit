package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1SimpleDropDownStateSelection {
/**
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/dropdown
    3. Verify “Simple dropdown” default selected value is correct
    Expected: “Please select an option”
    4. Verify “State selection” default selected value is correct
    Expected: “Select a State”
 */

    @Test
    public void StateSelection(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement simpleDropDown1 = driver.findElement(By.id("dropdown"));
        Select selectOption = new Select(simpleDropDown1);
        String actualOption = selectOption.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Please select an option");
        System.out.println(actualOption + ": - is selected by default. Test PASSED!");

        WebElement simpleDropDown2 = driver.findElement(By.id("state"));
        Select selectState = new Select(simpleDropDown2);
        String actualSelected = selectState.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelected, "Select a State");
        System.out.println(actualSelected + ": - is selected by default.  Test PASSED!");
        driver.quit();
    }

}
