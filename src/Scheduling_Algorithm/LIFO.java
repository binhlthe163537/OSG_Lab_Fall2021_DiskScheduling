/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduling_Algorithm;

import java.util.ArrayList;

/**
 *
 * @author Legion
 */
public class LIFO {
    final int HIGH = 199;
    final int LOW = 0;
    public static void main() {
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Integer> queue1 = new ArrayList<>();
        ArrayList<Integer> queue2 = new ArrayList<>();

        int head, q_size;
        int seek = 0, diff, temp;
        float avg;
        q_size = Validation.Inputter.inputInteger("Input the number of disk locations: \t", false);
        head = Validation.Inputter.inputInteger("Enter initial head position: \t", false);
        System.out.println("\n Enter disk positions to read: ");

        for (int i = 0; i < q_size; i++) {
            temp = Validation.Inputter.inputInteger("", false);
            queue.add(temp);
        }

        queue.add(head);
        

        for (int j = queue.size()-1; j > 0; j--) {
            diff = Math.abs(queue.get(j) - queue.get(j-1));
            seek += diff;
            System.out.printf("Disk head moves from %d to %d with seek %d\n", queue.get(j), queue.get(j - 1), diff);
        }
//range = max - min;
//printf("Range is %d", range);
//seek =  seek - (max - min);        
        System.out.println("Total seek time is " + seek);
        avg = seek / (float) q_size;
        System.out.printf("Average seek time is %f\n", avg);
    }
}

