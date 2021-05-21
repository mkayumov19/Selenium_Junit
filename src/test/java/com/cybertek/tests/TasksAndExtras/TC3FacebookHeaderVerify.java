package com.cybertek.tests.TasksAndExtras;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3FacebookHeaderVerify {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://facebook.com");
        String expectedHeader = "Connect with friends and the world around you on Facebook.";
        WebElement header = driver.findElement(By.className("_8eso"));
        String actualHeader = header.getText();
        if (actualHeader.equals(expectedHeader)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
}
