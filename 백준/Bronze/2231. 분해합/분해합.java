import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 0;
        int digits = (int) Math.log10(N) + 1; // N의 자릿수 구하기
        int start = N - (digits * 9); // 최소 생성자 후보 (각 자리 최대 9이므로)

        if (start < 1) start = 1; // 1 이상이어야 함

        for (int i = start; i <= N; i++) {
            int sum = i;
            int num = i;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == N) {
                result = i;
                break; // 가장 작은 생성자를 찾으면 종료
            }
        }

        System.out.println(result);
    }
}
