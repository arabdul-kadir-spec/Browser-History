
import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();

        String currentPage = "Home";

        int choice;

        do {
            System.out.println("\n===== BROWSER HISTORY SYSTEM =====");
            System.out.println("Current Page: " + currentPage);
            System.out.println("1. Visit a website");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. View History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter website name: ");
                    String website = input.nextLine();

                    backStack.push(currentPage);
                    currentPage = website;
                    forwardStack.clear();

                    System.out.println("Website visited successfully.");
                    break;

                case 2:
                    if (!backStack.isEmpty()) {
                        forwardStack.push(currentPage);
                        currentPage = backStack.pop();

                        System.out.println("Moved back successfully.");
                    } else {
                        System.out.println("No previous page available.");
                    }
                    break;

                case 3:
                    if (!forwardStack.isEmpty()) {
                        backStack.push(currentPage);
                        currentPage = forwardStack.pop();

                        System.out.println("Moved forward successfully.");
                    } else {
                        System.out.println("No forward page available.");
                    }
                    break;

                case 4:
                    System.out.println("Current Page: " + currentPage);
                    System.out.println("Back History: " + backStack);
                    System.out.println("Forward History: " + forwardStack);
                    break;

                case 5:
                    System.out.println("Exiting Browser History System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        input.close();
    }
}


