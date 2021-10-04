package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LiasTask {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();
        driver.get("https://beknazarsuranchiyev.medium.com/top-17-java-coding-interview-questions-for-sdet-a978754eb078");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
//        driver.findElement(By.xpath("//div[@class='mm s']")).click();
        driver.findElement(By.xpath("//div[@class='ho s ab']/span/a")).click();

    }
}
