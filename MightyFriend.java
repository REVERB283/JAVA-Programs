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

public class MightyFriend {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T = Reader.nextInt();
		while (T-- > 0) {
			int N = Reader.nextInt();
			int K = Reader.nextInt();
			int[] m = new int[N / 2 + 1];
			int[] t = new int[N / 2 + 1];
			if (N % 2 != 0) {
				t[N / 2] = 0;
			}
			int x = 0;
			int y = 0;
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					m[x] = Reader.nextInt();
					x++;
				} else {
					t[y] = Reader.nextInt();
					y++;
				}
			}
			while (K-- > 0) {
				Arrays.sort(m);
				Arrays.sort(t);
				int temp = m[N / 2];
				m[N / 2] = t[1];
				t[1] = temp;
			}
			int sum1 = 0;
			for (int i = 0; i < N / 2 + 1; i++) {
				sum1 += m[i];
			}
			int sum2 = 0;

			for (int i = 0; i < N / 2 + 1; i++) {
				sum2 += t[i];
			}
			if (sum2 > sum1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
