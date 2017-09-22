
import java.util.Scanner;


public class Assignment2_6 {
 public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);      
        stackUsingQueue suq = new stackUsingQueue();                  
        /* Perform Stack Operations */          
        System.out.println("Stack Using Two Queues Test\n");  
        char ch;     
        do 
        {
            System.out.println("\nStack Operations");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check empty");
            System.out.println("5. Size");            
            int choice = scan.nextInt();
            switch (choice) 
            {
            case 1 : 
                System.out.println("Enter integer element to push");
                suq.push( scan.nextInt() );                 
                break;                          
            case 2 : 
                try
                {
                    System.out.println("Popped Element = "+ suq.pop() );
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }        
                break;                         
            case 3 : 
                try
                {
                    System.out.println("Peek Element = "+ suq.peek() );
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("Empty status = "+ suq.isEmpty() );
                break;                
            case 5 : 
                System.out.println("Size = "+ suq.getSize() ); 
                break;            
            default :  
                System.out.println("Wrong Entry \n ");
                break;
            }                 
            /* Display Stack */        
            suq.display();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);            
        } while (ch == 'Y'|| ch == 'y');                 
    }   
}
