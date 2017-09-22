
import java.util.Scanner;


public class ParenthesisBalance {

    private static final char paraLeft  = '(';
    private static final char paraRight = ')';
    private static final char braceLeft = '{';
    private static final char braceRight = '}';
    private static final char bracketLeft = '[';
    private static final char bracketRight = ']';

    public static boolean isBalanced(String s) {
        Stack stack = new Stack();
        
        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case paraLeft:
                    stack.push(paraLeft);
                    break;
                case braceLeft:
                    stack.push(braceLeft);
                    break;
                case bracketLeft:
                    stack.push(bracketLeft);
                    break;
                case paraRight:
                    if (stack.isEmpty()) {
                        return false;
                    }   if (stack.pop() != paraLeft) {
                        return false;
                    }  
                    break;
                case braceRight:
                    if (stack.isEmpty()) {
                        return false;
                    }   if (stack.pop() != braceLeft) {
                        return false;
                    }
                    break;
                case bracketRight:
                    if (stack.isEmpty()) {
                        return false;
                    }   if (stack.pop() != bracketLeft) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the parenthesis pattern you want to check: ");
//        String s = scan.next();
//        
//        System.out.println(isBalanced(s));

 Scanner scan = new Scanner(System.in);
        System.out.println("Number of Patterns to be checked:  ");
        String num = scan.next();
        int num1 = Integer.parseInt(num);
        
        for (int i = 0; i < num1; i++) {
            int j = i+1;
            System.out.println("Enter pattern "+j+":");
            String s = scan.next();
            Parenthesis p = new Parenthesis();
            p.isBalanced(s);
        }
    }
}
