import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        BigInteger moves = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
        System.out.println(moves);
        
        if (n <= 20) {
            hanoi(n, 1, 3, 2);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }
    }
    
    static void hanoi(int n, int from, int to, int sub) {
        if(n == 1) {
            move(from, to);
            return;
        }
        hanoi(n - 1, from, sub, to);
        move(from, to);
        hanoi(n - 1, sub, to, from);
    }
    
    static void move(int from, int to) {
        sb.append(from).append(" ").append(to).append("\n");
    }
}
