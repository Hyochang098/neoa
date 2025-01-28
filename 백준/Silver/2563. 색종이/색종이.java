import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[][] white=new int[100][100];
		for(int i =0;i<n;i++) {
			int x=sc.nextInt()-1;
			int y=sc.nextInt()-1;
			for(int j =y;j<y+10;j++) {
				for(int k=x; k<x+10;k++) {
					white[j][k]=1;
				}
			}
		}
		int count=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(white[i][j]==1)
					count+=1;
			}
		}
		System.out.println(count);
	}
}