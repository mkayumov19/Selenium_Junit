package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectDateDD {
    /**
   TC #3: Selecting date on dropdown and verifying
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/dropdown
    3. Select “December 1st, 1922” and verify it is selected.
    Select year using Select month using Select day using
    : visible text
    : value attribute : index number
     */

    @Test
    public void selectDate() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement yearLocator = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearLocator);
        selectYear.selectByVisibleText("1922");
        String actualYear = selectYear.getFirstSelectedOption().getText();
        String expectedYear = "1922";
        Assert.assertEquals(actualYear, "1942");

        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("11");
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth, "December");

        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(0);
        String actualDay = selectDay.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay, "1");
        System.out.println(actualMonth+ " " +actualDay+ "st, " +actualYear);

    }
}
