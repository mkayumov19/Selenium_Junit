package com.cybertek.tests.day6_testng_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setupClass(){
        System.out.println("---> Before CLASS runs once---");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---> After CLASS runs once---");
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("---> Before METHOD is running---");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("---> After METHOD is running...");
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("Running test1...");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(expected, actual);
//        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Running test2...");
    }


}
