package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.pages.TelerikPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {
    /*
     * 1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
     * 2.Drag and drop the small circle to bigger circle.
     * 3.Assert: -Text in big circle changed to: “You did great!”
     */
    @Test
    public void drag_and_drop_page(){
        Driver.getDriver().get(" https://demos.telerik.com/kendo-ui/dragdrop/index");
        TelerikPage telerikPage = new TelerikPage();
        Actions actions = new Actions(Driver.getDriver());
        telerikPage.acceptCookies.click();
        BrowserUtils.sleep(1);

        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("window.scrollBy(0,250)", "");
        BrowserUtils.sleep(1);

        //1st way.
        actions.dragAndDrop(telerikPage.smallCircle,telerikPage.bigCircle).perform();
        BrowserUtils.sleep(1);

        //Dropping outside of Big-circle.
        actions.dragAndDrop(telerikPage.smallCircle, telerikPage.wrongSpace).perform();
        BrowserUtils.sleep(1);

        //2nd way, longer way, but same thing/result
        actions.moveToElement(telerikPage.smallCircle).clickAndHold(telerikPage.smallCircle)
               .moveToElement(telerikPage.bigCircle).release().perform();

        String actualText = telerikPage.bigCircle.getText();
        String expectedText = "You did great!";
        Assert.assertEquals(actualText, expectedText);


    }
}
