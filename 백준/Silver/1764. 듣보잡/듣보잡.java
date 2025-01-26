import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<String, Integer> checkList = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String noListen = sc.next();
			checkList.put(noListen, checkList.getOrDefault(noListen, 0) + 1);
		}
		for (int i = 0; i < m; i++) {
			String noSee = sc.next();
			checkList.put(noSee, checkList.getOrDefault(noSee, 0) + 1);
		}
		ArrayList<String> noSeelisten = new ArrayList<>();
		for (var noSeenoListen : checkList.entrySet()) {
			if (noSeenoListen.getValue() == 2) {
				noSeelisten.add(noSeenoListen.getKey());
			}

		}
		Collections.sort(noSeelisten);
		System.out.println(noSeelisten.size());
		for (String name : noSeelisten) {
			System.out.println(name);
		}
	}
}