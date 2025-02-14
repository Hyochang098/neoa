import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		List<Object> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				int k = 1;
				String temp = String.valueOf(str.charAt(i));
				while (i + k < str.length() && str.charAt(i + k) != '+' && str.charAt(i + k) != '-') {
					temp += String.valueOf(str.charAt(i + k));
					k++;
				}
				list.add(Integer.parseInt(temp));
				i += k - 1;
			} else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				list.add(str.charAt(i));
			}
		}
		
		int result = (int) list.get(0);
		boolean check = true;

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).equals('-')) {
				check = false;
			} else if (list.get(i).equals('+')) {
				continue;
			} else {
				int num = (int) list.get(i);
				if (check) {
					result += num;
				} else {
					result -= num;
				}
			}
		}
		System.out.println(result);
	}
}