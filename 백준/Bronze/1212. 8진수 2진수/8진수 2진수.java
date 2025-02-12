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

		System.out.println(sb);
	}

	static String exchange(int a) {
		switch (a) {
		case 0:
			return "000";
		case 1:
			return "001";
		case 2:
			return "010";
		case 3:
			return "011";
		case 4:
			return "100";
		case 5:
			return "101";
		case 6:
			return "110";
		case 7:
			return "111";
		default:
			return "error";
		}
	}

	static String exchange1(int a) {
		switch (a) {
		case 0:
			return "0";
		case 1:
			return "1";
		case 2:
			return "10";
		case 3:
			return "11";
		case 4:
			return "100";
		case 5:
			return "101";
		case 6:
			return "110";
		case 7:
			return "111";
		default:
			return "error";
		}
	}
}
