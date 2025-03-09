import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 12015 - 가장 긴 증가하는 부분 수열2
    // 수열에서 수를 뽑아서 증가하는 길이가 얼마인지 확인

    // 이분탐색으로 인덱스를 찾고 적절한 위치에 값 갱신
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 수열 길이 입력
        
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄로 입력받기
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = list.size() - 1;
            int idx = list.size();

            // 이분 탐색
            while (left <= right) {
                int mid = (left + right) / 2;
                if (list.get(mid) >= arr[i]) {
                    right = mid - 1;
                    idx = mid;
                } else {
                    left = mid + 1;
                }
            }

            // 적절한 위치에 값 삽입 또는 갱신
            if (idx == list.size()) {
                list.add(arr[i]);
            } else {
                list.set(idx, arr[i]);
            }
        }

        System.out.println(list.size()); // LIS 길이 출력
    }
}
