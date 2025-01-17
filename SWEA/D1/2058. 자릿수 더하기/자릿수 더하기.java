import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int a = number/1000;
        int b = (number%1000)/100;
        int c = (number%100)/10;
        int d = number%10;
        int sum = a + b + c + d;
        System.out.println(sum);
        
        
    }
}