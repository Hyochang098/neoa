import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a =in.nextInt();
        int b =in.nextInt();
        int count= 0;
        for(int i=b;i<=a;i++){
            count = 1+count;
            if(i == a){
                break;
            }
                }
        System.out.println(count);

    }
}
