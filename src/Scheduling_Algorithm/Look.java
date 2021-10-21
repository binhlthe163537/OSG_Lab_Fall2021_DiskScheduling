/*
  LOOK Algorithm
  - Heads move in only one direction until there are no
    more requests in that direction, then the direction
    is reversed.
*/

package Scheduling_Algorithm;

/**
 *
 * @author Legion
 */
public class Look {
    final static int LOW = 0;
    final static int HIGH = 199;
    public static void main() {
        int[] queue = new int[20];
        int[] queue1 = new int[20], queue2 = new int[20];
        int head, q_size;
        int seek = 0, diff, max, min, range, temp, temp1=0, temp2=0;
        float avg;
        q_size = Validation.Inputter.inputInteger("Input the number of disk locations: \t", false);
        head = Validation.Inputter.inputInteger("Enter initial head position: \t", false);
        System.out.println("\n Enter disk positions to read: ");
        
        for (int i = 0; i < q_size; i++) {
            temp = Validation.Inputter.inputInteger("", false);
            //queue1 - elems greater than head , queue2 - elems less than head
            if (temp >= head) {
                queue1[temp1] = temp;
                temp1++;
            } else {
                queue2[temp2] = temp;
                temp2++;
            }
        }
        
        //sort queue1 - increasing order
        for (int i = 0; i < temp1-1; i++) {
            for (int j = i+1; j<temp1; j++) {
                if (queue1[i] > queue1[j]) {
                    temp = queue1[i];
                    queue1[i] = queue1[j];
                    queue1[j] = temp;
                }                
            }
        }
        
        //sort queue2 - decreasing order
        for(int i=0; i<temp2-1; i++){
            for(int j=i+1; j<temp2; j++){
                if(queue2[i] < queue2[j]){
                    temp = queue2[i];
                    queue2[i] = queue2[j];
                    queue2[j] = temp;
                }
            }
        }
        
        if(Math.abs(head-LOW) >= Math.abs(head-HIGH)){
            int i;
            int j;

            for(i=1,j=0; j<temp1; i++,j++){
                queue[i] = queue1[j];
            }

            for(i=temp1+1, j=0; j<temp2; i++, j++){
                queue[i] = queue2[j];
            }

        } else {
            int i;
            int j;

            for(i=1,j=0; j<temp2; i++,j++){
                queue[i] = queue2[j];
            }

            for(i=temp2+1, j=0; j<temp1; i++, j++){
                queue[i] = queue1[j];
            }

        }
        
        queue[0] = head;
        for (int j = 0; j < q_size; j++) {
            diff = Math.abs(queue[j+1] - queue[j]);
            seek += diff;
            System.out.printf("Disk head moves from %d to %d with seek %d\n", queue[j], queue[j+1], diff);
        }
//range = max - min;
//printf("Range is %d", range);
//seek =  seek - (max - min);        
        System.out.println("Total seek time is " + seek);
        avg = seek/ (float) q_size;
        System.out.printf("Average seek time is %f\n", avg);
        
        
    }
}
