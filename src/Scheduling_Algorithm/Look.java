/*
  LOOK Algorithm
  - Heads move in only one direction until there are no
    more requests in that direction, then the direction
    is reversed.
*/

package Scheduling_Algorithm;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Legion
 */
public class Look {
    final static int LOW = 0;
    final static int HIGH = 199;
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
            //queue1 - elems greater than head
            if (temp >= head) {
                queue1.add(temp);
            } else {
                queue2.add(temp);
            }
        }
        
        //sort queue1 - increasing order
        Collections.sort(queue1);
        
        //sort queue2
        Collections.sort(queue2);
        queue.add(head);
        if (Math.abs(head - LOW)<= Math.abs(head - HIGH)) {
            for (int i = 0; i < queue1.size(); i++) {
                queue.add(queue1.get(i));
            }
            for (int i = queue2.size()-1; i >= 0; i--) {
                queue.add(queue2.get(i));
            }
        } else {
            for (int i = 0; i < queue2.size(); i++) {
                queue.add(queue2.get(i));
            }     
            for (int i = queue1.size()-1; i >= 0; i--) {
                queue.add(queue1.get(i));
            }
        }
        
        for (int j = 0; j < queue.size() - 1; j++) {
            diff = Math.abs(queue.get(j+1) - queue.get(j));
            seek += diff;
            System.out.printf("Disk head moves from %d to %d with seek %d\n", queue.get(j), queue.get(j+1), diff);
        }
//range = max - min;
//printf("Range is %d", range);
//seek =  seek - (max - min);        
        System.out.println("Total seek time is " + seek);
        avg = seek/ (float) q_size;
        System.out.printf("Average seek time is %f\n", avg);
        
        
    }
}