
import java.util.Scanner;


public class Assignment2_9 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String you want to check: ");
        String str = scan.next();
        
        Assignment2_9 check = new Assignment2_9();
        boolean result = check.checkUnique(str);
        if (result) {
            System.out.println("String has all unique characters!");
        } else {
            System.err.println("String does not have all unique characters!");
        }

    }

    public boolean checkUnique(String str) {

        boolean[] strSet = new boolean[256];//boolean array representing each character in char set

        for (int i = 0; i < str.length(); i++) {

            int val = str.charAt(i);//we assign a character to an int so its ASCII value gets stored..!
            if (strSet[val]) { //if its already true
                return false; //we have a duplicate
            }
            strSet[val] = true; //set boolean value representing that character to be true
        }
        return true; // all characters in string was unique..!
    }
}
