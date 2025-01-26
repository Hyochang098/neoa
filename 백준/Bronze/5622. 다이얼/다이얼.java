import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		char[] arr = new char[word.length()];
		int[] ans = new int[word.length()];
		for(int i = 0; i<word.length();i++) {
			arr[i]= word.charAt(i);
		}
		for(int i = 0; i<word.length();i++) {
			ans[i]=exchange(arr[i]);
		}
		int num = 0;
		for(int i = 0; i<word.length();i++) {
			int answer = 0;
			switch (ans[i]) {
			case 2:
				answer = 3;
				break;
			case 3:
				answer = 4;
				break;
			case 4:
				answer = 5;
				break;
			case 5:
				answer = 6;
				break;
			case 6:
				answer = 7;
				break;
			case 7:
				answer = 8;
				break;
			case 8:
				answer = 9;
				break;
			case 9:
				answer = 10;
				break;
			}
			num+=answer;
		}
		System.out.println(num);
	}
	public static int exchange(char a) {
		int num=1;
		switch (a){
		case 'A': 
		case 'B': 
		case 'C':
			num = 2;
			return num;
		case 'D': 
		case 'E': 
		case 'F':
			num = 3;
			return num;
		case 'G': 
		case 'H': 
		case 'I':
			num = 4;
			return num;
		case 'J': 
		case 'K': 
		case 'L':
			num = 5;
			return num;
		case 'M': 
		case 'N': 
		case 'O':
			num = 6;
			return num;
		case 'P': 
		case 'Q': 
		case 'R':
		case 'S':
			num = 7;
			return num;
		case 'T': 
		case 'U': 
		case 'V':
			num = 8;
			return num;
		case 'W': 
		case 'X': 
		case 'Y':
		case 'Z':
			num = 9;
			return num;
			
		}
		return num;
	}
}