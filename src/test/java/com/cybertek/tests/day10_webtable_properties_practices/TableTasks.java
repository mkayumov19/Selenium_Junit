package com.cybertek.tests.day10_webtable_properties_practices;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TableTasks {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("dataTablesUrl");

        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
        //driver.get(ConfigurationReader.getProperty("dataTablesUrl"));  --- same thing as above one.
    }

    @Test
    public void task3_return_tims_due_amount(){
        String timsFirstName = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']")).getText();
        String expectedFirstName = "Tim";
        String timsLastname = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[.='Conway']")).getText();
        String expectedLastName = "Conway";
        String timsDue = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[4]")).getText();
        String expectedDue = "$50.00";
        String timsEmail = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/following-sibling::td")).getText();
        String expectedEmail = "tconway@earthlink.net";
        System.out.println("Customer Full Name: "+ timsFirstName + " "+ timsLastname + "| Customer Due amount: "
                          + timsDue +"| Customer Email: "+timsEmail);
        Assert.assertEquals(timsFirstName,expectedFirstName);
        Assert.assertEquals(timsLastname,expectedLastName);
        Assert.assertEquals(timsDue,expectedDue);
        Assert.assertEquals(timsEmail,expectedEmail);

    }
        @Test
        public void task4_verify_order_method(){
            TableUtils.verifyOrder(driver,"Tim");
        }
        @Test
        public void task5_print_all_table_info(){
        TableUtils.printAllInfo(driver);

        }
}
