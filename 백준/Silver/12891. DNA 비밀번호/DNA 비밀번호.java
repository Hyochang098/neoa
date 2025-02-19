import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken()); // DNA 문자열의 길이
        int p = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분 문자열의 길이

        String str = br.readLine(); // DNA 문자열

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 'A' 최소 개수
        int c = Integer.parseInt(st.nextToken()); // 'C' 최소 개수
        int g = Integer.parseInt(st.nextToken()); // 'G' 최소 개수
        int t = Integer.parseInt(st.nextToken()); // 'T' 최소 개수

        // 각 문자의 개수를 저장할 변수
        int cnt_a = 0, cnt_c = 0, cnt_g = 0, cnt_t = 0;
        int ans = 0;

        // 첫 번째 윈도우에서 문자 개수 카운트
        for (int i = 0; i < p; i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'A': cnt_a++; break;
                case 'C': cnt_c++; break;
                case 'G': cnt_g++; break;
                case 'T': cnt_t++; break;
            }
        }

        // 첫 번째 윈도우가 조건을 만족하는지 확인
        if (cnt_a >= a && cnt_c >= c && cnt_g >= g && cnt_t >= t) {
            ans++;
        }

        // 슬라이딩 윈도우 적용
        for (int i = 1; i <= s - p; i++) {
            // 윈도우의 왼쪽 끝 문자 처리
            char out = str.charAt(i - 1);
            switch (out) {
                case 'A': cnt_a--; break;
                case 'C': cnt_c--; break;
                case 'G': cnt_g--; break;
                case 'T': cnt_t--; break;
            }

            // 윈도우의 오른쪽 끝 문자 처리
            char in = str.charAt(i + p - 1);
            switch (in) {
                case 'A': cnt_a++; break;
                case 'C': cnt_c++; break;
                case 'G': cnt_g++; break;
                case 'T': cnt_t++; break;
            }

            // 조건을 만족하는지 확인
            if (cnt_a >= a && cnt_c >= c && cnt_g >= g && cnt_t >= t) {
                ans++;
            }
        }

        // 결과 출력
        System.out.println(ans);
    }
}
