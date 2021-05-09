package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {

    //1 - set up the browser driver
        WebDriverManager.chromedriver().setup();

    //2 - create instance of selenium webdriver
        WebDriver driver = new ChromeDriver();

    //3 - get the page for tesla.com
        driver.get("https://www.tesla.com");
        System.out.println("Current title: = " + driver.getTitle());

        Thread.sleep(3000);
        driver.get("https://www.toyota.com");
        System.out.println("Current title: = " + driver.getTitle());

    // going back using navigations:
        Thread.sleep(3000);
        driver.navigate().back();

    // going forward page:
        Thread.sleep(3000);
        driver.navigate().forward();

    // refreshing page:
        Thread.sleep(3000);
        driver.navigate().refresh();

    //going too another url using
        Thread.sleep(3000);
        driver.navigate().to("https://www.google.com");
        System.out.println("Current title: = " + driver.getTitle());

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

    // opens browser FullScreen
        driver.manage().window().fullscreen();

    // opens browser max size (not full screen)
        driver.manage().window().maximize();

    // it will only close one current open browser or tab:
//        driver.close();

    //
        driver.quit();

    }

}
