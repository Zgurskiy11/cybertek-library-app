package com.cybertek.library.utilities;

public class BrowserUtils {
    //Method that will accept int, Wait for given second duration

    public static void sleep(int second)  {
        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //now we can call it BrowserUtils.sleep(1) --> one sec wait
    }
}
