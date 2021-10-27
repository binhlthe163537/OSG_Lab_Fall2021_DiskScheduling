/*
    Scan - Disk Scheduling Algorithm (Elevator)
    scans down towards the nearest end and then when it hits the bottom,
    it scans up servicing the requests that it didn't get going down.
    If a request comes in after it has been scanned it will not be serviced
    until the process comes back down or moves back up.
 */
package Scheduling_Algorithm;

import java.util.Arrays;
import java.util.Scanner;

import MyInit.Init;

public class Scan {

    public static void main() {
        Scanner input = new Scanner(System.in);
        int head;
        int[] queue;
        int seekTime;
        double avg;
        int dloc = 0;  //location of disk(head) in arr

        System.out.print("Input no of disk locations: ");
        int qSize = Integer.parseInt(input.nextLine());

        queue = new int[qSize + 1];
        System.out.print("Enter head position: ");
        head = Integer.parseInt(input.nextLine());

        System.out.println("Input elements in disk queue: ");
        if (Validation.Inputter.isRanDom("You want to random " + qSize + " location(s)? (y/n)")) 
        {
            Init.randomProcessToFile(qSize, "Process data.txt");
            int[] buffer = Init.readTextFile("Process data.txt");
            for (int i = 0; i < qSize; i++) 
                queue[i] = buffer[i];
        } 
        else 
            for (int i = 0; i < qSize; i++) 
                queue[i] = Validation.Inputter.inputInteger("Enter location " + (i + 1) + ": ", false);
        queue[qSize] = head;
        //sort disk locations queue
        Arrays.sort(queue);
        dloc = Arrays.binarySearch(queue, head);

        for(int i = dloc; i < queue.length - 1; i++)
            System.out.println("Move " + queue[i] + " to " + queue[i + 1]);

        System.out.println("Move " + queue[queue.length - 1] + " to " + queue[dloc - 1]);

        for(int i = dloc - 1; i > 0; i--)
            System.out.println("Move " + queue[i] + " to " + queue[i - 1]);
        
        seekTime = 2 * queue[queue.length - 1] - queue[dloc] - queue[0];
        avg = seekTime / (double)qSize;  
        System.out.println("Total seek time is " + seekTime);
        System.out.println("Average seek time is " + avg);
        input.close();
    }
}