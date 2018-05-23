import java.io.IOException;
import java.util.Scanner;

public class DibsFibs {

	static long m = 1000000007L;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		try {
			while (T-- > 0) {
				int M = input.nextInt();
				int N = input.nextInt();
				long a[] = new long[M];
				long b[] = new long[M];
				for (int i = 0; i < M; i++) {
					a[i] = input.nextLong();
				}
				for (int i = 0; i < M; i++) {
					b[i] = input.nextLong();
				}
				long result = 0L;
				if (N == 1) {
					for (int i = 0; i < M; i++)
						result = (result + a[i]) % m;
					result = (result * M) % m;
				} else if (N == 2) {
					for (int i = 0; i < M; i++)
						result = (result + b[i]) % m;
					result = result * M;
				} else if (N == 3) {
					long r1 = 0L;
					long r2 = 0L;
					for (int i = 0; i < M; i++) {
						r1 = (r1 + a[i]) % m;
						r2 = (r2 + b[i]) % m;
					}
					r1 = (r1 * M) % m;
					r2 = (r2 * M) % m;
					result = (r1 + r2) % m;
				} else {
					long r1 = 0L;
					long r2 = 0L;
					long[] fib = new long[N];
					fib[0] = 1L;
					fib[1] = 1L;
					for (int i = 2; i < N; i++) {
						fib[i] = (fib[i - 2] + fib[i - 1]) % m;
					}
					for (int i = 0; i < M; i++) {
						r1 = (r1 + a[i]) % m;
						r2 = (r2 + b[i]) % m;
					}
					r1 = (((r1 * M) % m) * fib[N - 3]) % m;
					r2 = (((r2 * M) % m) * fib[N - 2]) % m;
					result = (r1 + r2) % m;
				}
				System.out.println(result);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(-1);
		}
	}
}
