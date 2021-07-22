package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ClickLocator {

    @Test
    public void example01(){

        //1. Open Chrome browser2. Go to http://practice.cybertekschool.com/multiple_buttons 3. Click on Button 1

        Driver.getDriver().get("http://practice.cybertekschool.com/multiple_buttons");
        Driver.getDriver().findElement(By.xpath("//button[@onclick='button1()']")).click();
    }

}
