import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> checklist = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            checklist.put(num, checklist.getOrDefault(num, 0) + 1);
        }
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int checking = Integer.parseInt(st.nextToken());
            sb.append(checklist.getOrDefault(checking, 0)).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
