import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		int n = sc.nextInt();
		int perimeter = 2 * (width + height);
		int[] stores = new int[n];

		for (int i = 0; i < n; i++) {
			int dir = sc.nextInt();
			int dist = sc.nextInt();
			stores[i] = getDistance(dir, dist, width, height);
		}

		int dongDir = sc.nextInt();
		int dongDist = sc.nextInt();
		int donggeun = getDistance(dongDir, dongDist, width, height);

		int sum = 0;
		for (int store : stores) {
			int distance = Math.abs(donggeun - store);
			sum += Math.min(distance, perimeter - distance);
		}

		System.out.println(sum);
	}

	static int getDistance(int direction, int distance, int width, int height) {
		switch (direction) {
		case 1:
			return distance;
		case 2:
			return width + height + (width - distance);
		case 3:
			return 2 * (width + height) - distance;
		case 4:
			return width + distance;
		default:
			return 0;
		}
	}
}
