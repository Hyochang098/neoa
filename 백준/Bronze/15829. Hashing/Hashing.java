import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); 
        String str = sc.next(); 
        long hash = 0; 
        int r = 31; 
        int m = 1234567891;
        
        long a = 1; 
        
        for (int i = 0; i < n; i++) {
            int chark = str.charAt(i) - 'a' + 1; 
            hash = (hash + chark * a % m) % m; 
            a = (a * r) % m; 
        }
        
        System.out.println(hash); 
    }
}
