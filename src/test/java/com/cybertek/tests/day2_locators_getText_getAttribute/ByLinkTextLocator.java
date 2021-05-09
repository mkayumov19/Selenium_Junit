package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByLinkTextLocator {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://Google.com");

        driver.findElement(By.linkText("Gmail")).click();
        String actualTitleGmail = driver.getTitle();
        String expectedTitleGmail = "Gmail";

        if(actualTitleGmail.contains(expectedTitleGmail)){
            System.out.println("Gmail Title matches expected. Test Passed");
        }else{
            System.out.println("Failed, Title does not match");
        }
        driver.navigate().back();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google Title matches expected. Test Passed");
        }else{
            System.out.println("Failed, Title does not match");
        }

    }
}
