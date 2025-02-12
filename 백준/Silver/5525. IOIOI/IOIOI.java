import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		char[] sample = new char[2 * n + 1];
		for (int i = 0; i < sample.length; i++) {
			if (i % 2 == 0) {
				sample[i] = 'I';
			} else {
				sample[i] = 'O';
			}
		}

		char[] arr = new char[m];
		String str = br.readLine();
		for (int i = 0; i < m; i++) {
			arr[i] = str.charAt(i);
		}

		int cnt = 0;
		for (int i = 0; i < m - sample.length+1; i++) {
			boolean check = true;
			for (int j = 0; j < sample.length; j++) {
				if (arr[i + j] != sample[j]) {
					check = false;
					break;
				}
				
			}
			if (check) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
