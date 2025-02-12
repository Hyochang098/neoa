import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		if (str.equals("0")) {
			System.out.println(0);
			return;
		}
		int[] arr = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';
		}
		StringBuilder sb = new StringBuilder();
		sb.append(exchange1(arr[0]));
		for (int i = 1; i < str.length(); i++) {
			sb.append(exchange(arr[i]));
		}
		System.out.println(sb.toString());
	}

	static String exchange(int a) {
		String result = "";
		switch (a) {
		case 0:
			result = "000";
			break;
		case 1:
			result = "001";
			break;
		case 2:
			result = "010";
			break;
		case 3:
			result = "011";
			break;
		case 4:
			result = "100";
			break;
		case 5:
			result = "101";
			break;
		case 6:
			result = "110";
			break;
		case 7:
			result = "111";
			break;
		}
		return result;

	}

	static String exchange1(int a) {
		String result = "";
		switch (a) {
		case 1:
			result = "1";
			break;
		case 2:
			result = "10";
			break;
		case 3:
			result = "11";
			break;
		case 4:
			result = "100";
			break;
		case 5:
			result = "101";
			break;
		case 6:
			result = "110";
			break;
		case 7:
			result = "111";
			break;
		}
		return result;

	}
}