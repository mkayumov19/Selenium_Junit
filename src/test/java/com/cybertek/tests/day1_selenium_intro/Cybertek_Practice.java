package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cybertek_Practice {
    public static void main(String[] args) {

//  1.Open Chrome browser
//  2.Go to https://practice.cybertekschool.com
//  3.Verify URL containsExpected: cybertekschool
//  4.Verify title: Expected: Practice

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String expectedUrl = "cybertekschool";
        if(currentUrl.contains(expectedUrl)){
            System.out.println("Current URL contains: " + expectedUrl);
        }else{
            System.out.println("URL does not contain or typo in: " + expectedUrl);
        }
        String currentTitle = driver.getTitle();
        String expectedTitle = "Practice";
        if(expectedTitle.equals(currentTitle)){
            System.out.println("Title is equal to expected: " + expectedTitle);
        }else{
            System.out.println("Expected title: " + expectedTitle + " Current title: " + currentTitle);
        }

    }
}
