import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] light = new int[n];
		for (int i = 0; i < n; i++) {
			light[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int num = sc.nextInt();
			if (s == 1) {
				for (int j = 0; j < n; j++) {
					if ((j + 1) % num == 0) {
						light[j] = onOff(light[j]);
					} else
						continue;
				}
			} else if (s == 2) {
                int center = num - 1;
                light[center] = onOff(light[center]); // 기준 스위치 무조건 반전

                int left = center - 1;
                int right = center + 1;

                while (left >= 0 && right < n && light[left] == light[right]) {
                    light[left] = onOff(light[left]);
                    light[right] = onOff(light[right]);
                    left--;
                    right++;
                }
            }
        }
		for (int i = 0; i < n; i++) {
			System.out.print(light[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}

	public static int onOff(int a) {
		if (a == 0)
			a = 1;
		else if (a == 1)
			a = 0;
		return a;

	}
}