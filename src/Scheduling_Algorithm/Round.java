
package Scheduling_Algorithm;

import java.util.*;

public class Round {

    public static void main() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the no. of processes: ");
        int n = in.nextInt();
        int[] at = new int[n];
        int[] bt = new int[n];
        int[] bts = new int[n];
        int[] ct = new int[n];
        int[] st = new int[n];
        Queue<Integer> rq = new LinkedList<>();
        int[] wt = new int[n];
        int[] tat = new int[n];
        System.out.println("Enter the arrival time: \t");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            at[i] = in.nextInt();
        }

        System.out.println("Enter the burst time: \t");
        for (int i = 0; i < n; i++) {
            bt[i] = in.nextInt();
            bts[i] = bt[i];
        }

        for (int i = 0; i < n; i++) {
            sum = sum + bt[i];
        }
        System.out.print("Enter the time quantum: \t");
        int tq = in.nextInt();
        int t = 0;
        int i = 0;
        int count = 1;
        rq.add(i);
        st[0] = 1;
        while (t < sum) {
            int k = rq.remove();
            if (bt[k] > tq) {
                bt[k] = bt[k] - tq;
                t = t + tq;
                if (count < n) {
                    for (int j = 1; j < n; j++) {
                        if (st[j] != 1) {
                            if (at[j] <= t) {
                                rq.add(j);
                                st[j] = 1;
                                count++;
                            }
                        }
                    }
                }
                if (bt[k] > 0) {
                    rq.add(k);
                }
            } else {
                if (bt[k] != 0) {
                    t = t + bt[k];
                    ct[k] = t;
                    bt[k] = 0;
                }
            }
            System.out.println(rq + " " + t);
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int l = 0; l < n; l++) {
            tat[l] = ct[l] - at[l];
            wt[l] = tat[l] - bts[l];
            sum1 = sum1 + tat[l];
            sum2 = sum2 + wt[l];
        }
        for (int l = 0; l < n; l++) {
            System.out.println("p" + l + "  " + at[l] + "  " + bts[l] + "  " + ct[l] + "  " + tat[l] + "  " + wt[l]);
        }
        System.out.printf("Average tat is: %.2f\n" , (double) sum1 / n);
        System.out.printf("Average wt is : %.2f\n" , (double) sum2 / n);
    }
}


