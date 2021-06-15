package com.cybertek.MyTasksAndExtras;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC03FindElementsApple {
    public static void main(String[] args) {

//1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
// 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

// 3.Click to all of the headers one by one
        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));
        for (int eachLink = 1; eachLink < headerLinks.size()-1; eachLink++) {
//            System.out.println(headerLinks.get(eachLink).getText());
            headerLinks.get(eachLink).click();
            headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));
// 4.Print out the titles of the each page
//          a.Mac, iPad, iPhone, Watch, TV, Music, Support
            System.out.println("Current title in the page: " + driver.getTitle());

// 5.Print out total number of links in each page
            List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
            System.out.println("Total number of links in current page: " +  allLinks.size());

            int linksWithNoText = 0;
            int linksWithText = 0;

            for (WebElement each : allLinks) {
                if (each.getText().isEmpty()){
                    linksWithNoText++;
                }else{
                    linksWithText++;
                }
            }

// 6.While in each page:
//      a.Print out how many link is missing textTOTAL
            System.out.println("Current page links with No text: " + linksWithNoText);
//      b.Print out how many link has textTOTAL
            System.out.println("Current page links with text: " + linksWithText);

        }

    }
}










