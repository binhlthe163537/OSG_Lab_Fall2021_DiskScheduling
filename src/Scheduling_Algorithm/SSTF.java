package Scheduling_Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

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

        System.out.println("Enter queue size: ");
        qSize = Integer.parseInt(input.nextLine());

        queue2 = new int[qSize];
        System.out.println("Input Elements: ");
        for (int i = 0; i < qSize; i++) {
            queue.add(Integer.parseInt(input.nextLine()));
        }

        System.out.println("Enter initial head position: ");
        head = Integer.parseInt(input.nextLine());

        for (int i = 0; i < qSize; i++) {
            int diff = Math.abs(head - queue.get(0));
            int buffer = 0;
            for(int j = 0; j < queue.size(); j++)
            {
                if(diff > Math.abs(head - queue.get(j)))
                {
                    diff = Math.abs(head - queue.get(j));
                    buffer = j;
                }
            }
            System.out.println("Move " + head + " to " + queue.get(buffer) + " with seek " + diff);
            head = queue.get(buffer);
            queue2[i] = diff;
            queue.remove(buffer);

        }
        for (int i = 0 ; i < qSize ; i++)
        {
            seek += queue2[i];
        }
        System.out.println("Total seek time is " + seek);
        avg = seek / (float) qSize;
        System.out.println("Average seek time is " + avg);
        input.close();
    }
}