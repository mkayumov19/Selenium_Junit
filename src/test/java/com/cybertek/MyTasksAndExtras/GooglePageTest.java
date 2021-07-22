package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GooglePageTest {

    @Test
    public void inspectPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
//        Driver.getDriver().get("https://www.javatpoint.com/selenium-interview-questions");


//      1st question:
        Actions actions = new Actions(Driver.getDriver());
        WebElement searchBar = Driver.getDriver().findElement(By.name("q"));
        actions.contextClick(searchBar).perform();

//      2nd question:
//        WebElement title = Driver.getDriver().findElement(By.tagName("title"));
//        String actual = title.getAttribute("textContent");
//        System.out.println("Actual title: " + actual);
//        String expected = "Google";
////        String expected2 = "Top 50 Selenium Interview Questions (2021) - javatpoint";
//        Assert.assertEquals(actual, expected);

//     3rd question:
                

    }

}
