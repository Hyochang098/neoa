import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Long> a=new ArrayList<>();
    static void dfs(long x,int last){
        a.add(x);
        for(int d=0;d<last;d++) dfs(x*10+d,d);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        for(int i=0;i<=9;i++) dfs(i,i);
        Collections.sort(a);
        System.out.println(n>=a.size()?-1:a.get(n));
    }
}
