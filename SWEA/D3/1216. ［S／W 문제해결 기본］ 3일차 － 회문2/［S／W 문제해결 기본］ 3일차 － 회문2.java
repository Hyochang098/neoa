import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			sc.nextLine();
			char[][] arr = new char[100][100];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextLine().toCharArray();
			}

			int garo = 1;

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = j; k < 100; k++) {
						int left = j;
						int right = k;
						boolean felin = true;
						while (left < right) {
							if (arr[i][left] != arr[i][right]) {
								felin = false;
								break;
							}
							left++;
							right--;
						}
						if (felin)
							garo = Math.max(garo, k-j + 1);
					}
				}
			}

			int sero = 1;
			for (int j = 0; j < 100; j++) {
				for (int i = 0; i < 100; i++) {
					for (int k = i; k < 100; k++) {
						int up = i;
						boolean felin = true;
						int down = k;
						while (down > up) {
							if (arr[up][j] != arr[down][j]) {
								felin = false;
								break;
							}
							up++;
							down--;
						}
						if (felin)
							sero = Math.max(sero, k-i + 1);
					}
				}
			}

			int ans=Math.max(sero,garo);
			System.out.println("#" + t + " " + ans);
		}

	}

}