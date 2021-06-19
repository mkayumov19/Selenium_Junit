package com.cybertek.tests.day10_webtable_properties_practices;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableTasks extends TestBase {

    @Test
    public void task3_return_tims_due_amount() {
        String url = ConfigurationReader.getProperty("dataTablesUrl");
        driver.get(url);
        String timsFirstName = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']")).getText();
        String expectedFirstName = "Tim";
        String timsLastname = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[.='Conway']")).getText();
        String expectedLastName = "Conway";
        String timsDue = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/../td[4]")).getText();
        String expectedDue = "$50.00";
        String timsEmail = driver.findElement(By.xpath("//table[@id='table1']//td[.='Tim']/following-sibling::td")).getText();
        String expectedEmail = "tconway@earthlink.net";
        System.out.println("Customer Full Name: " + timsFirstName + " " + timsLastname + "| Customer Due amount: "
                + timsDue + "| Customer Email: " + timsEmail);
        Assert.assertEquals(timsFirstName, expectedFirstName);
        Assert.assertEquals(timsLastname, expectedLastName);
        Assert.assertEquals(timsDue, expectedDue);
        Assert.assertEquals(timsEmail, expectedEmail);

    }

    @Test
    public void task4_verify_order_method() {
        String url = ConfigurationReader.getProperty("dataTablesUrl");
        driver.get(url);
        TableUtils.verifyOrder(driver, "Tim");
    }

    @Test
    public void task5_print_all_table_info() {
        String url = ConfigurationReader.getProperty("dataTablesUrl");
        driver.get(url);
        TableUtils.printAllInfo(driver);

    }
}
