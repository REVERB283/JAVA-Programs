import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Reader {
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

public class MinDelete {

	public static int GCD(int a, int b) {
		if (a == 0)
			return b;
		return GCD(b % a, a);
	}

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T = Reader.nextInt();
		while (T-- > 0) {
			int N = Reader.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Reader.nextInt();
			}
			Arrays.sort(arr);
			int result = 0;
			for (int i = 0; i < N; i++) {
				result = GCD(arr[i], result);
			}
			if (result == 1) {
				System.out.println(0);
			} else {
				int result1 = 0;
				int del = 0;
				for (int i = 0; i < N; i++) {
					result1 = GCD(arr[i], result1);
					if (result1 != 0) {
						del++;
					}
				}
				System.out.println(del);
				if (del == N) {
					System.out.println(-1);
				} else {
					System.out.println(del);
				}
			}
		}
	}
}
