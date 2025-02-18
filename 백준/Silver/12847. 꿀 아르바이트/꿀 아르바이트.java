import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] salary = new int[n];

        for (int i = 0; i < n; i++) {
            salary[i] = Integer.parseInt(st.nextToken());
        }

        if (m == 0) {
            System.out.println(0);
            return;
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += salary[i];
        }
        long junsu = sum;

        for (int i = m; i < n; i++) {
            sum += salary[i];
            sum -= salary[i - m];
            junsu = Math.max(junsu, sum);
        }
        System.out.println(junsu);
    }
}