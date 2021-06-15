package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC4SelectMultipleDropdownValues {
    /**
    TC #4: Selecting value from multiple select dropdown
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/dropdown
    3. Select all the options from multiple select dropdown.
    4. Print out all selected values.
    5. Deselect all values.
    */

    @Test
    public void MultipleValueDD() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement languageDD = driver.findElement(By.xpath("//select[@name='Languages']"));
        languageDD.click();
        Select selectLang = new Select(languageDD);
        List<WebElement> languages = selectLang.getOptions();
        for (WebElement each : languages) {
            System.out.println(each.getText());
        }
        selectLang.deselectAll();

    }
}
