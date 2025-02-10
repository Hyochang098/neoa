import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        while (!str.equals("0")) { 
            boolean felindron = true;
            
            for (int i = 0; i < (str.length() / 2); i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    felindron = false;
                    break;
                }
            }
            
            if (felindron)
                System.out.println("yes");
            else
                System.out.println("no");
            
            str = sc.nextLine(); 
        }

    }
}
