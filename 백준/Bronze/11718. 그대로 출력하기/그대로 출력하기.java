import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n;
        while ((n = br.readLine()) != null) {
            sb.append(n).append("\n");
        }
        
        System.out.print(sb);
    }
}
