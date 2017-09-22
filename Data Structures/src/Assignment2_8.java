
import java.util.Scanner;

public class Assignment2_8 {

    public static void main(String[] args) {
        
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList list3 = new LinkedList();

        System.out.println(" Linked List\n");
        list1.addNodeAtHead(1);
        list1.addNodeAtHead(2);
        list1.addNodeAtHead(3);
        list1.addNodeAtHead(4);
        list1.addNodeAtHead(5);
        System.out.println("List1: ");
        list1.display();
             
        list1.getTailNode().setNext(list1.getHeadNode());
        list1.checkCircular();
        
        list2.addNodeAtHead(6);
        list2.addNodeAtHead(7);
        list2.addNodeAtHead(8);
        list2.addNodeAtHead(9);
        list2.addNodeAtHead(10);
        System.out.println("\n");
        System.out.println("List2: ");
        list2.display();
        list2.checkCircular();
        
        
        list3.addNodeAtTail(11);
        list3.addNodeAtTail(12);
        list3.addNodeAtTail(13);
        list3.addNodeAtTail(14);
        list3.addNodeAtTail(15);
        System.out.println("\n");
        System.out.println("List3: ");        
        list3.display();
        list3.getTailNode().setNext(list3.getHeadNode());
        list3.checkCircular();
        

    }
}
