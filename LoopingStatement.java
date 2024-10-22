


/*
   data type
   variables types 
   control statement: if, else if, switch

   looping statement: for, while, do while

   OOPs

 */
import java.util.Scanner;

public class LoopingStatement 
{
    @SuppressWarnings("UnnecessaryContinue")
    public static void main(String[] args)
     {
        int no = 15;
        System.err.println("loop start");
        for (int i = 0; i < no; i++) 
        {
            System.out.println("value of i = "+i);
            if(i ==10)
            {
                break;
                // continue;
            }
        }
        System.out.println("loop end");
        System.out.println("while loop start");
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while(i < no)
        {
            System.out.println("inside while loop starting, i = "+i);
            i++;
            System.out.println("inside while loop ending, i = "+i);
        }
        while (true)
         {
            System.out.println("please enter your pin ");
            int pin = sc.nextInt();
            if(pin == 1122)
            {
                System.out.println("pin is correct");
                break;
            }
            else
            {
                System.out.println("pin is incorrect, please try again");
            }
          }
          System.out.println("end of program");
    }
}
