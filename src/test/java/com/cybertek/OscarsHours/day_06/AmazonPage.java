package com.cybertek.OscarsHours.day_06;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='nav-a  '])[1]")
    public WebElement buyAgain;

    @FindBy(xpath = "(//a[@class='nav-a  '])[2]")
    public WebElement liveStreams;

    @FindBy(xpath = "(//a[@class='nav-a  '])[3]")
    public WebElement shopperToolKit;

    @FindBy(xpath = "(//a[@class='nav-a  '])[4]")
    public WebElement healthHouse;

    @FindBy(xpath = "(//a[@class='nav-a  '])[5]")
    public WebElement amzBasics;

    @FindBy(xpath = "(//a[@class='nav-a  '])[6]")
    public WebElement coupons;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchTab;

    @FindBy(xpath = "(//div[@class='a-section a-spacing-medium a-text-center'])[1]")
    public WebElement firstHatLink;

    @FindBy(xpath = "(//span[@class='a-dropdown-container'])[1]")
    public WebElement qtyButton;

    @FindBy(xpath = "//select[@id='quantity']")
    public WebElement qty2;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCart;

    @FindBy(xpath = "//span[@id='hlb-view-cart']")
    public WebElement cartBtn;

    @FindBy(css = "span[class='a-size-medium a-color-base sc-price " +
            "sc-white-space-nowrap sc-product-price a-text-bold']")
    public WebElement singleItemPrice;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base " +
            "sc-price sc-white-space-nowrap'])[1]")
    public WebElement totalPrice;

    @FindBy(xpath = "//select[@name='quantity']")
    public  WebElement qty1;

    @FindBy(css = "span[id='sc-subtotal-label-buybox']")
    public WebElement newQty;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-buybox']/span")
    public WebElement newTotal;

    public static void amzElements() {
        AmazonPage page1 = new AmazonPage();
        List<WebElement> allCategories = new ArrayList<>(Arrays.asList(page1.buyAgain, page1.liveStreams,
                page1.shopperToolKit, page1.healthHouse, page1.amzBasics, page1.coupons));
        for (WebElement each : allCategories) {
            System.out.println(each.getText().toString());
        }
    }
}
