package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByIdLocator {
    public static void main(String[] args) {

//        EtsyTitle Verification
//        1.Open Chrome browser
//        2.Go to https://www.etsy.com
//        3.Search for “wooden spoon”
//        4.Verify title: Expected: “Wooden spoon | Etsy”

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);
        String actualSpoonPageTitle = driver.getTitle();
        String expectedSpoonPageTitle = "Wooden spoon | Etsy";
        if(actualSpoonPageTitle.equals(expectedSpoonPageTitle)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test Failed!");
        }

    }
}
