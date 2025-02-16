import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		
		HashMap<String, String> note = new HashMap<>();
		for(int i=0;i<n;i++) {
			String[] arr = (br.readLine()).split(" ");
			note.put(arr[0], arr[1]);
		}
		for(int i=0;i<m;i++) {
			String str = br.readLine();
			sb.append(note.get(str)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}