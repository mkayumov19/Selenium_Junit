package com.cybertek.MyTasksAndExtras;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class BeanTimeTables {

    @Test
    public void timeTables() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beanbeanbean.com/times-tables.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement numOne = driver.findElement(By.xpath("//p[@id='pFirstNumber']"));
        String firstNum = numOne.getText();
        WebElement numTwo = driver.findElement(By.xpath("//p[@id='pSecondNumber']"));
        String secondNum = numTwo.getText();
//        System.out.println(firstNum);
//        System.out.println(secondNum);
        int one = Integer.parseInt(firstNum);
        int two = Integer.parseInt(secondNum);
        int result = one * two;
        WebElement answer = driver.findElement(By.id("pAnswerNumber"));
        Thread.sleep(3000);
        answer.click();
        answer.sendKeys(String.valueOf(result) + Keys.ENTER);
        driver.findElement(By.xpath("//button[@id='buttonSubmit']")).click();
    }

}
