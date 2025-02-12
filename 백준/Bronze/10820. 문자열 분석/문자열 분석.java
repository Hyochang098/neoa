import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String str = sc.nextLine();

			int small = 0;
			int large = 0;
			int number = 0;
			int space = 0;

			for (char c : str.toCharArray()) {
				if (Character.isDigit(c)) {
					number++;
				} else if (Character.isAlphabetic(c)) {
					if (Character.isLowerCase(c)) {
						small++;
					} else if (Character.isUpperCase(c)) {
						large++;
					}
				} else if (c == ' ') {
					space++;
				}
			}
			System.out.println(small + " " + large + " " + number + " " + space);
		}
	}
}