import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		double[] arr = new double[a];
		double max = 0;
		for (int i = 0; i < a; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max)
				max = arr[i];
		}
		double sum = 0;
		for (int i = 0; i < a; i++) {
			arr[i] = (arr[i] / max) * 100;
			sum +=arr[i];
		}

		double ans =  (sum/a);
		System.out.print(ans);
	}

}