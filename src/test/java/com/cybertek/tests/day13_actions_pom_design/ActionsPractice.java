package com.cybertek.tests.day13_actions_pom_design;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractice {

    @Test
    public void p2_double_click_test(){
        Driver.getDriver().get(" https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame("iframeResult");
        WebElement text2DoubleClick = Driver.getDriver().findElement(By.id("demo"));
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);
        actions.doubleClick(text2DoubleClick).perform();
//        actions.perform();
        String expectedInStyle = "red";
        String actualInStyle = text2DoubleClick.getAttribute("style");
        Assert.assertTrue(actualInStyle.contains(expectedInStyle));

    }

}
