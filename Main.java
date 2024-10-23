import java.util.Scanner;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("Enter a command (type 'exit' to quit): ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("exit")) {
                System.out.println("You entered: " + input);
            }
        }

        System.out.println("Program exited.");
        scanner.close();
    }
}