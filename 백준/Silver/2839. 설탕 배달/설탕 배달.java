import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		HashSet<Integer> checking = new HashSet<Integer>();
		int count = 0;
		ArrayList<Integer> previous = new ArrayList<Integer>();
		while (true) {
			if(previous.contains(0))
				break;
			if(count==5000) {
				count=-1;
				break;
			}
			if (count == 0) {
				previous.add(n);
				checking.add(n);
			}
			ArrayList<Integer> current = new ArrayList<Integer>();
			count++;
			for (int i = 0; i < previous.size(); i++) {
				int three = previous.get(i) - 3;
				int five = previous.get(i) - 5;
				if (!checking.contains(three)) {
					current.add(three);
					checking.add(three);
				}
				if (!checking.contains(five)) {
					current.add(five);
					checking.add(five);
				}
			}
			previous = current;

		}
		System.out.println(count);
	}
}