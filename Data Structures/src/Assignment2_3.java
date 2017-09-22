
import java.util.Scanner;


public class Assignment2_3 {
  public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); 
        /* Creating object of class linkedQueue */   
        Queue queue = new Queue();            
        /* Perform Queue Operations */    
        System.out.println("Linked Queue Test\n"); 
        char ch;        
        do
        {
            System.out.println("\nQueue Operations");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Check empty");
            System.out.println("5. Size");
            int choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                queue.enqueue(scan.nextInt() );
                break;                         
            case 2 : 
                try 
                {
                    System.out.println("Removed Element = "+ queue.dequeue());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;                         
            case 3 : 
                try
                {
                    System.out.println("Peek Element = "+ queue.peek());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("Empty status = "+ queue.isEmpty());
                break;
 
            case 5 : 
                System.out.println("Size = "+ queue.size());
                break;  
 
            default : 
                System.out.println("Wrong Entry \n ");
                break;
            }                
                   
            queue.display();
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);            
        } while (ch == 'Y'|| ch == 'y');                                                            
    }   
}
