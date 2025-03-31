import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        double[][] robot = new double[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            robot[i][1] = Math.sqrt(x * x + y * y) / speed;
            robot[i][0] = i + 1;
        }

        Arrays.sort(robot, (a, b) -> Double.compare(a[1], b[1]));

        for (int i = 0; i < n; i++) {
            sb.append((int) robot[i][0]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
