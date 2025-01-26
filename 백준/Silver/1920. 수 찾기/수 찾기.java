import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		HashMap<Integer, Integer> checklist = new HashMap<>();
		for (int i = 0; i < a; i++) {
			int num = sc.nextInt();
			checklist.put(num, checklist.getOrDefault(num, 0) + 1);
		}
		int b = sc.nextInt();
		int[] checking = new int[b];
		for (int i = 0; i < b; i++) {
			checking[i] = sc.nextInt();
		}
		for (int i = 0; i < b; i++) {
			if (checklist.get(checking[i]) == null)
				System.out.println(0);
			else
				System.out.println(1);

		}
	}
}