import java.io.*;

public class Main {
    static String s;
    static boolean ok = false;

    static void dfs(String t) {
        if (ok) return;
        if (t.length() == s.length()) {
            if (t.equals(s)) ok = true;
            return;
        }
        if (t.endsWith("A")) dfs(t.substring(0, t.length() - 1));
        if (t.startsWith("B")) {
            String u = new StringBuilder(t.substring(1)).reverse().toString();
            dfs(u);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().trim();
        String t = br.readLine().trim();
        dfs(t);
        System.out.println(ok ? 1 : 0);
    }
}
