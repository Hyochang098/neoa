import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dices = new int[3];

        dices[0] = sc.nextInt();
        dices[1] = sc.nextInt();
        dices[2] = sc.nextInt();

        int price; 

        if (dices[0] == dices[1] && dices[1] == dices[2]) {
            price = 10000 + 1000 * dices[0];
        } 
        else if (dices[0] != dices[1] && dices[1] != dices[2] && dices[2] != dices[0]) {
            int max = dices[0];
            for (int i = 1; i < 3; i++) {
                if (dices[i] > max) {
                    max = dices[i];
                }
            }
            price = 100 * max;
        } 
        else {
            int same = (dices[0] == dices[1]) ? dices[0] : (dices[1] == dices[2]) ? dices[1] : dices[2];
            price = 1000 + 100 * same;
        }
        System.out.println(price);
    }
}

