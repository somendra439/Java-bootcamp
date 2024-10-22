/*
   data type
   variables types 
   control statement: if, else if, switch

   looping statement: for, while, do while

   OOPs

 */


public class LoopingStatement 
{
    public static void main(String[] args)
     {
        int no = 5;
        System.err.println("loop start");
        for (int i = 0; i < no; i++) 
        {
            System.out.println("value of i = "+i);
            if(i ==2)
            {
                break;
            }

        }
        System.err.println("loop end");
    }
}
