package Scheduling_Algorithm;

import java.util.Scanner;

import MyInit.Init;

public class  FCFS{

    public static void main() {
        Scanner input = new Scanner(System.in);
        int seek = 0;
        int diff;
        int head;
        float avg;
        int[] queue;

        System.out.println("FCFS Disk Scheduling");

        System.out.println("Enter queue size: ");
        int qSize = Integer.parseInt(input.nextLine());

        System.out.println("Enter initial head position: ");
        head = Integer.parseInt(input.nextLine());

        queue = new int[qSize + 1];

        System.out.println("Input Queue elements: ");
        if (Validation.Inputter.isRanDom("You want to random " + qSize + " location(s)? (y/n)")) 
        {
           Init.randomProcessToFile(qSize, "Process data.txt");
           int[] buffer = Init.readTextFile("Process data.txt");
           System.out.println("Random Successfully! Please view in Process data.txt\n");
           
           for(int i = 0; i < qSize; i++)
           {
               queue[i + 1] = buffer[i];
           }
        }
        else
        {
            for (int i = 1; i < qSize + 1; i++) {
                System.out.println("Enter location " + i + ": ");
                queue[i] = Integer.parseInt(input.nextLine());
            }
        }


        queue[0] = head;

        for (int j = 0; j < qSize; j++) {
            diff = Math.abs(queue[j + 1] - queue[j]);
            seek += diff;
            System.out.println("Move " + queue[j] + " to " + queue[j + 1] + " with seek " + diff);
        }

        System.out.println("Total Seek time is " + seek);
        avg = seek / (float) qSize;
        System.out.println("Average seek time is " + avg);
        
        MyInit.Init.saveProcessToFile(queue, "Output.txt", qSize);
        input.close();
        System.out.println("\nData are successfully saved in Output.txt");
    }

}