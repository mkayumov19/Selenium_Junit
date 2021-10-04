package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GroupTask {

//1. Go to : https://login2.nextbasecrm.com/
//2. Username : hr32@cybertekschool.com
//3. Password :UserUser
//4. AC# Verify users can send message by clicking "MESSAGE" tab

    static WebDriver driver = Driver.getDriver();

    @Test
    public void testSendMessage(){
        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr32@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);

        driver.findElement(By.id("feed-add-post-form-tab-message")).click();
        WebElement frameElem = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(frameElem);
        driver.findElement(By.xpath("//body[@ contenteditable='true']")).sendKeys("Hello World");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("blog-submit-button-save")).click();
    }

}
