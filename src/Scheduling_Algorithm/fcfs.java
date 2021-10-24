package Scheduling_Algorithm;

import java.util.Scanner;

public class FCFS {

    public static void main() {
        Scanner input = new Scanner(System.in);
        int seek = 0;
        int diff = 0;
        int head = 0;
        float avg;
        int[] queue;

        System.out.println("FCFS Disk Scheduling");

        System.out.println("Enter queue size: ");
        int qSize = Integer.parseInt(input.nextLine());

        queue = new int[qSize + 1];

        System.out.println("Input Queue elements: ");
        for (int i = 1; i < qSize + 1; i++) {
            queue[i] = Integer.parseInt(input.nextLine());
        }

        System.out.println("Enter initial head position: ");
        head = Integer.parseInt(input.nextLine());

        queue[0] = head;

        for (int j = 0; j < qSize; j++) {
            diff = Math.abs(queue[j + 1] - queue[j]);
            seek += diff;
            System.out.println("Move " + queue[j] + " to " + queue[j + 1] + " with seek " + diff);

        }

        System.out.println("Total Seek time is " + seek);
        avg = seek / (float) qSize;
        System.out.println("Average seek time is " + avg);
        input.close();
    }

}