import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 1부터 n까지
        m = sc.nextInt(); // 조합의 길이
        arr = new int[m];

        recursion(0, 1);
    }

    static void recursion(int cur, int start) {
        if (cur == m) { // 조합의 길이가 m이면 출력
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) { 
            arr[cur] = i;
            recursion(cur + 1, i + 1); 
        }
    }
}
