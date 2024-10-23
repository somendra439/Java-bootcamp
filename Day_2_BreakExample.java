public class BreakExample {
    public static void main(String[] args) {
        System.out.println(" for loop start ");
        for (int i = 1; i <= 20; i++) {
            if (i == 5) {
                System.out.println("Break at: " + i);
                break;  
            }
            System.out.println(i);
        }
        System.out.println(" for loop end ");

        System.out.println(" loop start ");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                continue;  
            }
            System.out.println(i);
        }
        System.out.println(" loop end ");

        int i = 1;

        System.out.println(" while loop start ");
        while (i <= 20) {
            if (i == 5 || i == 9) {
                i++;
                continue; 
            }
            System.out.println(i);
            i++;
        }
        System.out.println(" while loop end ");

        System.out.println(" loop start ");
        while (i <= 20) {
            if (i == 12) {
                System.out.println("Breaking at: " + i);
                break;  
            }
            System.out.println(i);
            i++;
        }
        System.out.println(" loop end ");
    }
}
    
    

