import java.util.*;
import java.lang.*;
import java.io.*;

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

public class MaxAss {

	public static void main(String[] args) throws IOException {
		Reader.init(System.in);
		int T = Reader.nextInt();
		while (T-- > 0) {
			int N = Reader.nextInt();
			int start[] = new int[N];
			int end[] = new int[N];
			int[][] matrix = new int[N][2];
			for (int i = 0; i < N; i++) {
				matrix[i][0] = Reader.nextInt();
				matrix[i][1] = Reader.nextInt();
			}
			Arrays.sort(matrix, new Comparator<int[]>() {

				@Override
				public int compare(final int[] entry1, final int[] entry2) {
					if (entry1[1] > entry2[1])
						return 1;
					else
						return -1;
				}
			});
			for (int i = 0; i < N; i++) {
				start[i] = matrix[i][0];
				end[i] = matrix[i][1];
			}
			int i = 0;
			int count = 1;
			for (int j = 1; j < N; j++) {
				if (start[j] >= end[i]) {
					count++;
					i = j;
				}
			}
			System.out.println(count);
		}
	}
}
