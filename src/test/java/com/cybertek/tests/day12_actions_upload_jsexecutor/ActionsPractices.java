package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ActionsPractices {

    @Test(priority = 1)
    public void tc15_actions_hover(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(img1).perform();
        BrowserUtils.sleep(2);
        String img1Text = Driver.getDriver().findElement(By.xpath("//*[.='name: user1']")).getText();
        Assert.assertTrue(img1.isDisplayed(), "User1 text is not displayed. FAIL!!!");

        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(img2).perform();
        BrowserUtils.sleep(2);
        String img2Text = Driver.getDriver().findElement(By.xpath("//*[.='name: user2']")).getText();
        Assert.assertTrue(img2.isDisplayed(), "User2 text is not displayed. FAIL!!!");

        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));
        actions.moveToElement(img3).perform();
        BrowserUtils.sleep(2);
        String img3Text = Driver.getDriver().findElement(By.xpath("//*[.='name: user3']")).getText();
        Assert.assertTrue(img3.isDisplayed(), "User3 text is not displayed. FAIL!!!");

    }

    @Test(priority = 2)
    public void scrolling_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        Actions actions = new Actions(Driver.getDriver());
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        //Scroll using actions object
        BrowserUtils.sleep(2);
        actions.moveToElement(cybertekSchoolLink).perform();
        Assert.assertTrue(cybertekSchoolLink.isDisplayed(),"Did not scroll down!");

        //Scrolling up using Keys.Page_UP button
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

//        BrowserUtils.sleep(2);
//        actions.sendKeys(Keys.PAGE_UP).perform();

        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();




    }

    @AfterTest
        public void tearDown(){
        Driver.getDriver().quit();
    }

}
