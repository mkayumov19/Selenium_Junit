package com.cybertek.OscarsHours.day_06;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AmazonTask extends AmazonPage {

    @Test
    public void amazonTest() {
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage page1 = new AmazonPage();
        page1.amzElements();

        page1.buyAgain.getText(); page1.liveStreams.getText(); page1.shopperToolKit.getText();
        page1.healthHouse.getText(); page1.amzBasics.getText();page1.coupons.getText();
        page1.searchTab.sendKeys(ConfigurationReader.getProperty("amazonHat") + Keys.ENTER);
        page1.firstHatLink.click();
        page1.qtyButton.click();
        Select select = new Select(page1.qty2);
        select.selectByVisibleText("2");
        page1.addToCart.click();
        page1.cartBtn.click();

        String actualSinglePrice = page1.singleItemPrice.getText();
        actualSinglePrice = actualSinglePrice.substring(1);
        double temp = Double.parseDouble(actualSinglePrice) * 2;
        String expectedTotal = "$" + String.format("%.2f", temp);
        String actualTotal = page1.totalPrice.getText();
        if (actualTotal.equalsIgnoreCase(expectedTotal)) {
            System.out.println("Single item price: " + actualSinglePrice);
            System.out.println("Total price for 2 items: " + actualTotal);
        } else {
            System.out.println("Prices don't match!");
        }
        Select select1 = new Select(page1.qty1);
        select1.selectByVisibleText("1");
        BrowserUtils.sleep(2);
        System.out.println(page1.newQty.getText());
        System.out.println("New item price: " + page1.newTotal.getText());

    }
}
