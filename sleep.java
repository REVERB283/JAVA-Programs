import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Reader{
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input){
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    	}

    static String next() throws IOException{
        while (! tokenizer.hasMoreTokens()){
            tokenizer = new StringTokenizer(reader.readLine());
        	}
        return tokenizer.nextToken();
    	}

    static int nextInt() throws IOException{
        return Integer.parseInt(next());
    	}
	
    static double nextDouble() throws IOException{
        return Double.parseDouble(next());
    	}
    static long nextLong() throws IOException{
    	return Long.parseLong(next());
    	}
	}

public class sleep {
	
	static int count = 0;
	
	public static int pen(int n, int m) {
		if(m==1) {
			return -1;
		}
		else if(n<m) {
			return count+n;
		}
		else if(n>m) {
			count+=m;
			return pen((n-m)+1,m);
			
		}
		else if(n==m){
			count+=m;
			return count+1;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T = Reader.nextInt();
		while(T-->0) {
			int n = Reader.nextInt();
			int m = Reader.nextInt();
//			System.out.println(pen(n,m));
			int result = pen(n,m);
			if(result==-1)
				System.out.println("No Sleep");
			else
				System.out.println(result);
			count=0;
		}
	}

}
