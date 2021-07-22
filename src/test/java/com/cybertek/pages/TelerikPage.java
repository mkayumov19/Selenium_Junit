package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelerikPage {

    public TelerikPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement smallCircle;

    @FindBy(xpath = "//div[@id='droptarget']")
    public WebElement bigCircle;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookies;

    @FindBy(xpath = "//h1[@class='kd-title']")
    public WebElement wrongSpace;



}
