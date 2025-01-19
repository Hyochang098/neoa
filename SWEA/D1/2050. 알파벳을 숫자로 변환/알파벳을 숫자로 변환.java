import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        for (int i =0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            int num = (int) ch;
            num = num-64;
            System.out.print(num+" ");

        }

    }
}