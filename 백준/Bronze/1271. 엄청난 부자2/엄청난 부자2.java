import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger(); 
        BigInteger m = sc.nextBigInteger(); 
        
        BigInteger ans = n.divide(m); 
        BigInteger less = n.remainder(m); 

        System.out.println(ans);
        System.out.println(less);
    }
}
