import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] liquid = new int[n];
		String[] temp = (br.readLine()).split(" ");
		for (int i = 0; i < n; i++) {
			liquid[i] = Integer.parseInt(temp[i]);
		}

		Arrays.sort(liquid);
		int right = n - 1;
		int left = 0;
		int ans = Integer.MAX_VALUE;
		int an_r=0;
		int an_l=0;
		while (left <right) {
			int sum = liquid[left] + liquid[right];
			if (Math.abs(sum) < Math.abs(ans)) {
				ans = sum;
				an_l=left;
				an_r=right;
			}
			if (sum == 0) {
				break;
			} else if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		bw.write(String.valueOf(liquid[an_l])+" "+String.valueOf(liquid[an_r]));
		bw.flush();
		bw.close();
	}
}