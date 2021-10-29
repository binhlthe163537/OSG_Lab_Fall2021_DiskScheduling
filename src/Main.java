
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
        String[] ops1 = { "LIFO", "Scan", "SSTF", "FCFS", "Clock", "Lock", "Cscan", "Exit" };
        String[] ops2 = { "Back to menu", "Exit" };
        int choice1 = 0;
        int choice2 = 0;
        while (choice1 < 8 || choice2 < 3)
        {
            choice1 = MyInit.Menu.choice(ops1);
            switch (choice1) 
            {
                case 1: 
                {
                    LIFO.main();
                    choice2 = MyInit.Menu.choice(ops2);
                    break;
                }
                case 2: 
                {
                    Scan.main();
                    choice2 = MyInit.Menu.choice(ops2);
                    break;
                }
                case 3: 
                {
                    SSTF.main();
                    choice2 = MyInit.Menu.choice(ops2);
                    break;
                }
                case 4: 
                {
                    FCFS.main();
                    choice2 = MyInit.Menu.choice(ops2);
                    break;
                }
                case 5: 
                {
                    Clock.main();
                    choice2 = MyInit.Menu.choice(ops2);
                    break;
                }
                case 6: 
                {
                    Look.main();
                    choice2 = MyInit.Menu.choice(ops2);
                    break;
                }
                case 7: 
                {
                    Cscan.main();
                    choice2 = MyInit.Menu.choice(ops2);
                    break;
                }
            }
        }
    }
}
