import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// 12015 - 가장 긴 증가하는 부분 수열2
	// 수열에서 수를 뽑아서 증가하는 길이가 얼마인지 확인

	// dp배열 만들고 i=n까지 돌면서 안에 j<n까지 돌면서 작은경우 카운트 올려줌->실패 n^2이여서 시간초과인듯?

	// 이분탐색으로->인덱스 넣을 곳을 찾는 
	// arr배열을 돌면서 값들을 찾고 리스트에 어디 넣을지 정하여 최댓값을 유지할 수 있게

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {

			int left = 0;
			int right = list.size() - 1;
			int idx = list.size();
			while (left <= right) {
				int mid =(left + right) / 2;
				if (list.get(mid) >= arr[i]) {
					right = mid - 1;
					idx = mid;
				} else {
					left = mid + 1;
				}
			}
			if (idx == list.size()) {
				list.add(arr[i]);
			} else {
				list.set(idx, arr[i]);
			}
		}
		System.out.println(list.size());
	}
}