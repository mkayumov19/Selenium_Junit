package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class TableUtils {

    public static void verifyOrder(WebDriver driver, String name) {
        List<WebElement> firstNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));
        for (WebElement eachName : firstNames) {
            if (eachName.getText().equals(name)) {
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.assertTrue(false, "Name does not exist in the List");
    }

        public static void printAllInfo(WebDriver driver) {
            List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[1]"));
            List<WebElement> firstNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));
            List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tr/td[3]"));
            List<WebElement> dueAmounts = driver.findElements(By.xpath("//table[@id='table1']//tr/td[4]"));
            List<WebElement> webSites = driver.findElements(By.xpath("//table[@id='table1']//tr/td[5]"));

            List<String> allInfo = new ArrayList<>();
            for (int i = 0; i < firstNames.size(); i++) {
                System.out.println("First Names: \t " + firstNames.get(i).getText());
                System.out.println("Last Names: \t " + lastNames.get(i).getText());
                System.out.println("Emails: \t " + emails.get(i).getText());
                System.out.println("Due Amounts: \t " + dueAmounts.get(i).getText());
                System.out.println("Websites: \t " + webSites.get(i).getText());
            }
        }

}
