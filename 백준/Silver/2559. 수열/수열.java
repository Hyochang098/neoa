import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 

        int[] temper = new int[n];

        st = new StringTokenizer(br.readLine());
        int total_temp=0;
        for (int i = 0; i < n; i++) {
            temper[i] = Integer.parseInt(st.nextToken());
            if(i<k) {
            	total_temp+=temper[i];
            }
        }

        int max = total_temp;

        for(int i=k;i<n;i++) {
        	total_temp = total_temp-temper[i-k]+temper[i];
        	max=Math.max(max,total_temp);
        }
        
//        for (int i = 0; i <= n - k; i++) {//완전탐색
//            int sum = 0;
//            for (int j = 0; j < k; j++) {
//                sum += temper[i + j]; 
//            }
//            max = Math.max(max, sum);
//        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
