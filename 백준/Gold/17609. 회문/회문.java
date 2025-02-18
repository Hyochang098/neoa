import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= t; tc++) {
			String str = sc.nextLine();
			System.out.println(felin(str));
		}
	}

	static int felin(String str) {

		int start = 0;
		int finish = str.length() - 1;
		while (start < finish) {
			if (str.charAt(start) != str.charAt(finish)) {
				if (palin(str, start+1, finish) || palin(str, start, finish-1)) {
					return 1;
				}
				return 2;
			}
			start++;
			finish--;
		}

		return 0;
	}

	static boolean palin(String str, int start, int finish) {
		while (start < finish) {
			if (str.charAt(start) != str.charAt(finish)) {
				return false;
			}
			start++;
			finish--;
		}
		return true;
	}
}