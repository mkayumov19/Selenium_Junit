package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilPractice {

    @Test
    public void simple_google_search_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("googleUrl"));
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        String searchValue = ConfigurationReader.getProperty("searchValue");
        searchBox.sendKeys(searchValue+ Keys.ENTER);

        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = searchValue;
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        Driver.getDriver().quit();
        Driver.closeDriver();

        Driver.getDriver().get("https://www.etsy.com");
        Driver.getDriver().get(ConfigurationReader.getProperty("put etsy in config.prop and use Key here"));
        Driver.closeDriver();

    }

}
