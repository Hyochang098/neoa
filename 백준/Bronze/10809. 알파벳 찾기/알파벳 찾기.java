import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		
		int[] inputArr = new int[A.length()];
		for (int i = 0; i<A.length();i++) {
			inputArr[i]=A.charAt(i)-97;
		}

		int[] arr= new int[26];
		for(int i=0; i<26; i++) {
			arr[i] = -1;
		}
		for(int j=0; j<A.length();j++) {
			if (arr[inputArr[j]]==-1) {
			arr[inputArr[j]]=j;}
		}
		for(int a:arr) {
			System.out.print(a+" ");
		}
		
		
	}

}
