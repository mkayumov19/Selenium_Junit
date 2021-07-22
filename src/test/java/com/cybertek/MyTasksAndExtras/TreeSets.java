package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSets {
    public static void main(String[] args) {
        Driver.getDriver().get("https://www.etsy.com/");
        Driver.getDriver().findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);
        List<WebElement> spoons = Driver.getDriver().findElements(By.xpath("//a[starts-with(@class,'listing-link wt-display-inline-block')]"));

        System.out.println("Number of wooden spoon links:"+spoons.size());
        SortedSet<String> spoonTitles = new TreeSet<>();
        Iterator<WebElement> spoonsIt = spoons.iterator();

        while(spoonsIt.hasNext()){
            WebElement link = spoonsIt.next();
            String title = link.getText();
            spoonTitles.add(title);
        }

        System.out.println("Number of unique wooden spoons : "+ spoonTitles.size());
        System.out.println(spoonTitles);

    }
}
