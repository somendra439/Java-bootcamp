import java.util.Scanner;

public class JavaScannerTest
 {
    public static void main(String[] args) 
    {
        System.out.println(" this is used print in console ");
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please enter anything you want: ");
        String readString = scanner.nextLine();
        System.out.println(readString);

        

    }
}
