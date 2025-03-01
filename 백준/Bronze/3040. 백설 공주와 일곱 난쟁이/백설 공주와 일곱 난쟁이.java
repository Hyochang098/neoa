import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dwarf = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
			sum += dwarf[i];
		}
		Loop:
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum-dwarf[i]-dwarf[j]==100) {
					dwarf[i]=0;
					dwarf[j]=0;
					break Loop;
				}
			}
		}
		Arrays.sort(dwarf);
		for(int i=2;i<9;i++) {
			System.out.println(dwarf[i]);
		}
	}
}