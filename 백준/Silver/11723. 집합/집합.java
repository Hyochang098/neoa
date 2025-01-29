import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> arr = new HashSet<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			String[] arr1 = str.split(" ");
			String order = arr1[0];

			switch (order) {
			case "add":
				int num1 = Integer.parseInt(arr1[1]);
				Boolean info = arr.contains(num1);
				if (info)
					arr.remove(num1);
				arr.add(Integer.parseInt(arr1[1]));
				break;
			case "remove":
				int num11 = Integer.parseInt(arr1[1]);
				Boolean info1 = arr.contains(num11);
				if (info1)
					arr.remove(num11);
				break;
			case "check":
				int num2 = Integer.parseInt(arr1[1]);
				Boolean info11 = arr.contains(num2);
				sb.append(info11 ? "1\n" : "0\n");
				break;
			case "toggle":
				int num111 = Integer.parseInt(arr1[1]);
				Boolean info2 = arr.contains(num111);
				if (info2)
					arr.remove(num111);
				else
					arr.add(num111);
				break;
			case "all":
				arr.clear();
				arr.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
				break;
			case "empty":
				arr.clear();
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
