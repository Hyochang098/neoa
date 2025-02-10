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
    	String a = st.nextToken();
    	String b = st.nextToken();
    	String c = st.nextToken();
    	String d = st.nextToken();
    	
    	String ab = a+b;
    	String cd = c+d;
    	long aa=Long.parseLong(ab);
    	long cc=Long.parseLong(cd);
    	long ans = aa+cc;
    	bw.write(String.valueOf(ans));
    	bw.flush();
    	bw.close();
    }
}
