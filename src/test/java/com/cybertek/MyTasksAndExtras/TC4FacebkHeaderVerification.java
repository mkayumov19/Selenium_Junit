package com.cybertek.MyTasksAndExtras;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4FacebkHeaderVerification {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://facebook.com");
        WebElement createPageLink = driver.findElement(By.className("_8esh"));
        String actualText = createPageLink.getAttribute("href");
        String expectedText = "registration_form";
        if(actualText.contains(expectedText)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }
}
