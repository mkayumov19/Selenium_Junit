package com.cybertek.MyTasksAndExtras;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2FacebookIncorrectTitle {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(" https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys("1234567890");
        driver.findElement(By.id("pass")).sendKeys("AppleChrome10"+ Keys.ENTER);
        Thread.sleep(4000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Log into Facebook";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Actual title: " + actualTitle);
            System.out.println("Expected title: " + expectedTitle);
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }



    }
}
