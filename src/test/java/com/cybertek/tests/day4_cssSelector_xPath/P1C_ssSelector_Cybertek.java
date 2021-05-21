//package com.cybertek.tests.day3_cssSelector_xPath;
//
//import com.cybertek.utilities.WebDriverFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class P1C_ssSelector_Cybertek {
//    public static void main(String[] args) {
//        System.out.println("Home link found? "+ isDisplayed("Home link"));
//
//    }
//
//    public static boolean isDisplayed(String word){
//            WebDriver driver = WebDriverFactory.getDriver("chrome");
//            driver.get("http://practice.cybertekschool.com/forgot_password");
//            WebElement homeLink, forgotPassword, emailText, emailBox, retrievePassword, powerCybertek;
//            forgotPassword = driver.findElement(By.tagName("Forgot Password"));
//            emailText = driver.findElement(By.cssSelector("label[for='email']"));
//            emailBox = driver.findElement(By.cssSelector("input[type='text']"));
//            retrievePassword = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
//            powerCybertek = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
//            if(word.equalsIgnoreCase("Home link")) {
//                homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
//            } else if (word.equalsIgnoreCase("")){
//
//                boolean homeFound = false;
//                if (homeLink.isDisplayed()) {
//                    return true;
//                } else {
//                    return false;
//
//
//                }
//            }
//
//    }
//}
