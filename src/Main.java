
import Scheduling_Algorithm.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Legion
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==========Main Menu===========");
        String[] ops = {"Round", "Scan", "SSTF", "FCFS","Clock","Lock","Cscan", "Exit"};
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i+1) + "-" + ops[i]);
        }
        int choice = Validation.Inputter.inputIntegerInRange("Enter choice: ", 1, ops.length);
        switch(choice) {
            case 1: {
                Round.main();
                break;
            }
            case 2: {
                SCAN.main();
                break;
            }
            case 3: {
                SSTF.main();
                break;
            }
            case 4: {
                fcfs.main();
                break;
            }
            case 5: {
                Clock.main();
                break;
            }
            case 6: {
                Look.main();
                break;
            }
            case 7: {
                Cscan.main();
                break;
            }
        }
        
    }
}
