/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Legion
 */
public class myLib {
    
    public static int getRandomInt(){
        Random rd = new Random();
        return rd.nextInt(Integer.MAX_VALUE);
    }

    public static int getRandomInt(int i, int i0) {
        Random rd = new Random();
        int randomNum = ThreadLocalRandom.current().nextInt(i, i0+1);
        return randomNum;
    }
    
    
    
}
