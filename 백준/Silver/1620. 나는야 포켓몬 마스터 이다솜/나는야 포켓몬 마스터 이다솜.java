import java.util.HashMap;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		HashMap<String, Integer> pokemondic = new HashMap<>();
		HashMap<Integer, String> numdic = new HashMap<>();
		for(int i =0; i<m;i++) {
			String pokemon = sc.next();
			pokemondic.put(pokemon, i+1);
			numdic.put(i+1, pokemon);
		}
		for(int i =0; i<n;i++) {
			String quest = sc.next();
			if(quest.matches("\\d+")) {
				int a = Integer.parseInt(quest);
				System.out.println(numdic.get(a));
			}else {
				System.out.println(pokemondic.get(quest));
			}
		}
	}
}