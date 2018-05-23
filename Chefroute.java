
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
	}

public class Chefroute{

	public static void main(String[] args) throws IOException{
	Reader.init(System.in);
	int T = Reader.nextInt();
	for(int i=0; i<T; i++){
		String s = Reader.next();
		String[] arr2 = s.split("");
		int[] arr1 = new int[arr2.length];
		for(int j=0; j<arr2.length; j++){
			if(arr2[j].equals("C")) arr1[j]=1;
			else if(arr2[j].equals("E")) arr1[j]=2;
			else if(arr2[j].equals("S")) arr1[j]=3;
			}
		int flag = 0;
		for(int j=0; j<(arr2.length-1); j++){
			if(arr1[j]<=arr1[j+1]){
				flag = flag + 1;
				}
			}
		if(flag==(arr2.length-1)) System.out.println("yes");
		else System.out.println("no");
		}
	}
}