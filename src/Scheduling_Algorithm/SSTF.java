package Scheduling_Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

import MyInit.Init;

public class SSTF {

    public static void main() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> queue = new ArrayList<>();
        int[] queue2;

        int head;
        int seek = 0;
        int qSize;
        float avg;

        System.out.println("SSTF Disk Scheduling");

        System.out.print("Enter queue size: ");
        qSize = Integer.parseInt(input.nextLine());

        queue2 = new int[qSize];

        System.out.print("Enter initial head position: ");
        head = Integer.parseInt(input.nextLine());
        
        System.out.println("Input Elements: ");
        if (Validation.Inputter.isRanDom("You want to random " + qSize + " location(s)? (y/n)")) 
        {
            Init.randomProcessToFile(qSize, "Process data.txt");
            int[] buffer = Init.readTextFile("Process data.txt");
            for (int i = 0; i < qSize; i++) 
                queue.add(buffer[i]);
        } 
        else 
            for (int i = 0; i < qSize; i++) 
                queue.add(Validation.Inputter.inputInteger("Enter location " + (i + 1) + ": ", false));



        for (int i = 0; i < qSize; i++) {
            int diff = Math.abs(head - queue.get(0));
            int buffer = 0;
            for(int j = 0; j < queue.size(); j++)
                if(diff > Math.abs(head - queue.get(j)))
                {
                    diff = Math.abs(head - queue.get(j));
                    buffer = j;
                }
            System.out.println("Move " + head + " to " + queue.get(buffer) + " with seek " + diff);
            head = queue.get(buffer);
            queue2[i] = diff;
            queue.remove(buffer);

        }
        for (int i = 0 ; i < qSize ; i++)
            seek += queue2[i];
        System.out.println("Total seek time is " + seek);
        avg = seek / (float) qSize;
        System.out.println("Average seek time is " + avg);
        input.close();
    }
}