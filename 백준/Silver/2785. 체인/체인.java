import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] L = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(L);

        int remain = N;
        int ret = 0;
        for (int i = 0; i < N; i++) {
            int need = remain - 1;
            // 남은 모든 체인을 연결할 만큼의 링이 이미 확보되었으면 중단
            if (ret >= need) break;
            // 이 체인 전체를 풀 때 부족량을 채울 수 있는지 확인
            if (ret + L[i] >= need) {
                ret = need;
                break;
            } else {
                ret += L[i];
                remain--;
            }
        }

        System.out.println(ret);
    }
}
