package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButoonText {

        @Test
        public void button(){

            Driver.getDriver().get("https://www.keynotesupport.com/internet/web-contact-form-example-radio-buttons.shtml");

            String actual = Driver.getDriver().findElement(By.xpath("//div[@id='align']/span[4]")).getText();
            String expected = "Microsoft Excel";
            Assert.assertEquals(actual, expected);
            System.out.println("Expected <" + expected + ">, actual = " + actual);
            Driver.closeDriver();


    }

}
