
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
        String[] ops = {"LIFO", "Scan", "SSTF", "FCFS","Clock","Lock", "Cscan", "Exit"};
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i+1) + "-" + ops[i]);
        }
        int choice = Validation.Inputter.inputIntegerInRange("Enter choice: ", 1, ops.length);
        switch(choice) {
            case 1: {
                LIFO.main();
                break;
            }
            case 2: {
                try{
                    Scan.main();
                } catch (Exception e) { 
                }
                
                break;
            }
            case 3: {
                try {
                    SSTF.main();
                } catch (Exception e){ 
                    System.err.println(e);
                }
                break;
            }
            case 4: {
                FCFS.main();
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
