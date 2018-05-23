import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

class Reader { // Reader class for inputs
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
}

public class Manager {

	public static void ReadFile(File f, Hashtable<Integer, HashSet> h, Hashtable<Integer, Integer> i)
			throws FileNotFoundException {
		Scanner in = new Scanner(f);
		int a = Integer.parseInt(in.nextLine());
		for (int j = 0; j < a; j++) {
			String[] str = in.nextLine().split(" ");
			i.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			HashSet<Integer> set = new HashSet<Integer>();
			for (int k = 2; k < str.length; k++) {
				set.add(Integer.parseInt(str[k]));
			}
			h.put(Integer.parseInt(str[0]), set);
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		Reader.init(System.in);
		int N = Reader.nextInt();
		Hashtable<Integer, HashSet> h = new Hashtable<Integer, HashSet>();
		Hashtable<Integer, Integer> i = new Hashtable<Integer, Integer>();
		File f = new File("./src/database.txt");
		ReadFile(f, h, i);
		long start1 = System.currentTimeMillis();
		Transaction Tr = new Transaction(h, i, 1);
		for (int j = 0; j < N; j++) {
			Thread t1 = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						Tr.run();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t1.start();
			try {
				t1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1);
	}
}
