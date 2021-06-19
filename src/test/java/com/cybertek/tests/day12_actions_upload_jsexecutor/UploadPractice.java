package com.cybertek.tests.day12_actions_upload_jsexecutor;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadPractice {

    @Test
    public void upload_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        String path = "/Users/maxkayumov/Desktop/Screen Shot 2021-06-14 at 17.45.38 PM.png";
        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        chooseFile.sendKeys(path);
        uploadButton.click();
        WebElement fileUploadedMessage = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedMessage.isDisplayed());

    }

}
