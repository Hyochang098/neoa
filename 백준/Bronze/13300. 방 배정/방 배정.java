import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int k = sc.nextInt(); 

        int[][] school = new int[2][6]; 
        
        for (int i = 0; i < n; i++) {
            int sex = sc.nextInt();   
            int grade = sc.nextInt(); 
            school[sex][grade - 1]++; 
        }

        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                ans += (school[i][j] + k - 1) / k;
            }
        }

        System.out.println(ans);
    }
}
