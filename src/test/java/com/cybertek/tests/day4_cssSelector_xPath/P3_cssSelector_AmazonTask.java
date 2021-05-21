package com.cybertek.tests.day4_cssSelector_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_cssSelector_AmazonTask {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        WebElement searchBar = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        searchBar.sendKeys("wooden spoon"+ Keys.ENTER);

        String expectedTitle = "Amazon.com : wooden spoon";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title match! Test Passed!!!");
        } else {
            System.out.println("Title don't match! Test Failed!!!");
        }

    }
}
