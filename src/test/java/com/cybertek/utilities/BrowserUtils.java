package com.cybertek.utilities;

public class BrowserUtils {

    /**
     * Method that will accept int
     * Wait for given second duration
     */

    public static void sleep(int second) {
        second *= 1000;         // 1 second = 1000 milliseconds
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("Something happened in the Sleep Method");
        }

    }

//    public static void implicitWait(int second){
//
//    }

}
