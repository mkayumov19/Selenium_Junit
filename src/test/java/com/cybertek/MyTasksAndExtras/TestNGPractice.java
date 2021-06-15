package com.cybertek.MyTasksAndExtras;

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;

public class TestNGPractice {

    @Before
    public void setUp() throws Exception {
        System.out.println("Before annotation");
    }

    @Test
    public void test() {
        System.out.println("Test annotations");
    }

    @Test
    public void test2() {
        System.out.println("Test2 annotations");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After annotation");
    }

}
