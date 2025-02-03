import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        StringBuilder result = new StringBuilder();
        StringBuilder str = new StringBuilder();
        boolean check = false;

        for (char ch : S.toCharArray()) {
            if (ch == '<') { 
                result.append(str.reverse());
                str.setLength(0);
                check = true;
                result.append(ch);
            } else if (ch == '>') {
                check = false;
                result.append(ch);
            } else if (check) {
                result.append(ch);
            } else {
                if (ch == ' ') {
                    result.append(str.reverse()).append(' ');
                    str.setLength(0);
                } else {
                    str.append(ch);
                }
            }
        }

        result.append(str.reverse());

        System.out.println(result);
    }
}
