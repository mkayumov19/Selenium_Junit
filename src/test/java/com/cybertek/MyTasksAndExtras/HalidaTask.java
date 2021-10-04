package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HalidaTask {

    //1.Go to https://www.apple.com/
    //2.Click on all of the headers one by one a Mac, iPad, iPhone, Watch, TV, Music, Support
    //and verify titles included Mac, iPad, iPhone, Watch, TV, Music, Support

    @Test
    public void Test1(){
        Driver.getDriver().get("https://www.apple.com/");
                String[] headerList={"Mac","iPad","iPhone","Watch","TV","Music","Support"};
        // WebElement Mac=Driver.getDriver().findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-mac']"));
        for (int i = 0; i < headerList.length; i++) {
            WebElement headers=Driver.getDriver().findElement(By.xpath("//a[contains(@class,'"+headerList[i].toLowerCase()+"')]"));
            headers.click();
            System.out.println("Title = " + Driver.getDriver().getTitle());

        }
    }
}