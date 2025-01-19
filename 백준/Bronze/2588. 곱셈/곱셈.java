import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int first = b/100;
        int second = (b%100)/10;
        int third =  (b%10);
        
        System.out.println(a*third);
        System.out.println(a*second);
        System.out.println(a*first);
        System.out.println(a*b);
    }
}
