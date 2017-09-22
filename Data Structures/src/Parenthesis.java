
import java.util.Scanner;

public class Parenthesis {

    public char pLeft = '(';
    public char pRight = ')';
    public char bLeft = '{';
    public char bRight = '}';
    public char brLeft = '[';
    public char brRight = ']';

    public void isBalanced(String str) {
        Stack stack = new Stack();
        boolean check;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == pLeft) {
                stack.push(str.charAt(i));

            } else if (str.charAt(i) == bLeft) {
                stack.push(str.charAt(i));

            } else if (str.charAt(i) == brLeft) {
                stack.push(str.charAt(i));

            } else if (str.charAt(i) == pRight) {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                if (stack.pop() == pLeft) {
                    check = true;
                } else {
                    check = false;
                }
            } else if (str.charAt(i) == bRight) {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                if (stack.pop() == bLeft) {
                    check = true;
                } else {
                    check = false;
                }

            } else if (str.charAt(i) == brRight) {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                if (stack.pop() == brLeft) {
                    check = true;
                } else {
                    check = false;
                }
            } else {
                check = false;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of Patterns to be checked:  ");
        String num = scan.next();
        int num1 = Integer.parseInt(num);
        
        for (int i = 0; i < num1; i++) {
            int j = i+1;
            System.out.println("Enter pattern "+j+":");
            String s = scan.next();
            
        }
    }
}
