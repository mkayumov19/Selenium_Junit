package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TC02FindElementsApple {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.apple.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
}
//1.Open Chrome browser
// 2.Go to https://www.apple.com
// 3.Click to iPhone
// 4.Print out the texts of all links
// 5.Print out how many link is missing text
// 6.Print out how many link has text
// 7.Print out how many total link