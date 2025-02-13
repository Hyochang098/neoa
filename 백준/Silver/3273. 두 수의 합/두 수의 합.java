import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); 

        int x = sc.nextInt();

        int left = 0, right = n - 1;
        int cnt = 0; 

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {
                cnt++;  
                left++; 
                right--;
            } else if (sum < x) {
                left++; 
            } else {
                right--;
            }
        }

        System.out.println(cnt);
    }
}
