import java.util.Scanner;
import java.util.regex.Pattern;

public class IP_Address_Validation {

    public static final String IPV4_REGEX = "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}";
    

    public static String check(String ip)
    {
        if(Pattern.compile(IPV4_REGEX, Pattern.CASE_INSENSITIVE | Pattern.DOTALL).matcher(ip).matches())
            return "true";        
        else
            return "false";
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while(N-->0)
        {
            String str = sc.nextLine();
            System.out.println(IP_Address_Validation.check(str));
        }
    }
}