package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.Driver;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ClickAllButtonsSameTime {

    @Test
    public void danielWalker() {
        Driver.getDriver().get("http://te.dev.secureci.com/Exercise2.html");
                List<WebElement> list = Driver.getDriver().findElements(By.cssSelector(".slider"));
        for (WebElement webElement : list) {
            new Clicker(webElement).run();
        }
    }
//================================================================================================

    class Clicker implements Runnable {
        private final WebElement element;

        public Clicker(WebElement element) {
            this.element = element;
        }

        @Override
        public void run() {
            element.click();
        }
    }

    @After
    public void teardown() {
        Driver.getDriver().quit();
    }
}