
import java.util.Scanner;

public class Assignment2_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack();

        System.out.println("Stack Test\n");
        char ch;
        do {
            System.out.println("\nStack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");
            
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to push");
                    stack.push(scan.nextInt());
                    break;
                case 2:
                    try {
                        System.out.println("Popped Element = " + stack.pop());
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Peek Element = " + stack.peek());
                    } catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Empty status = " + stack.isEmpty());
                    break;
                case 5:
                    System.out.println("Size = " + stack.getSize());
                    break;
                case 6:
                    System.out.println("Stack = \n");
                    stack.display();
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
         
            stack.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}
