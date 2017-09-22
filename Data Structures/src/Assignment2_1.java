
import java.util.Scanner;

public class Assignment2_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedList list = new LinkedList();
        System.out.println(" Linked List\n");
        char ch;

        do {
            System.out.println("\n Linked List Operations\n");
            System.out.println("1. Add node at head");
            System.out.println("2. Add node at tail");
            System.out.println("3. Add node at (Nth) position");
            System.out.println("4. Delete node at (Nth) position");
            System.out.println("5. Check empty");
            System.out.println("6. Get size");
            System.out.println("7. Reverse a linked list");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.addNodeAtHead(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to insert");
                    list.addNodeAtTail(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Enter integer element to insert");
                    int num = scan.nextInt();
                    System.out.println("Enter position");
                    int pos = scan.nextInt();
                    if (pos <= 1 || pos > list.getSize()) {
                        System.out.println("Invalid position\n");
                    } else {
                        list.addNodeAtPosition(num, pos);
                    }
                    break;
                case 4:
                    System.out.println("Enter position");
                    int p = scan.nextInt();
                    if (p < 1 || p > list.getSize()) {
                        System.out.println("Invalid position\n");
                    } else {
                        list.deleteNodeAt(p);
                    }
                    break;
                case 5:
                    System.out.println("Empty status = " + list.isEmpty());
                    break;
                case 6:
                    System.out.println("Size = " + list.getSize() + " \n");
                    break;

                case 7:                  
               
                    Node newhead = list.getHeadNode().Reverse(list.getHeadNode());
                    newhead.Traverse(null);
                    break;
                    
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
