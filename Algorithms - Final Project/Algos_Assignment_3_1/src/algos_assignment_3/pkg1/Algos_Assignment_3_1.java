
package algos_assignment_3.pkg1;

import java.util.Scanner;

/**
 *
 * @author Mugdha
 */
public class Algos_Assignment_3_1 {

    public static void main(String[] args) {
        
        int m;
        
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of matrices");
        m = in.nextInt();
        
                    
        if(m<=0){
            System.out.println("Can't form matrix!");
        }else if(m<=2048){
            System.out.println("Performing simple multiplication!");
            Simple simple = new Simple();
            simple.simple(m);
            
        }else{
            System.out.println("Performing Strassen multiplication!");
            Strassen strassen = new Strassen();
            strassen.strassen(m);
        }
        
    }
    
}
