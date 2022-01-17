package math;

import java.io.*;
import java.util.*;

public class Main_6064 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int lcm = M * N / gcd(M, N);
			int n = 0;
			int ans = -1;
			while (n * M < lcm) {
				if (((n * M) + x - y) % N == 0) {
					ans = (n * M) + x;
					break;
				}
				n++;
			}

			System.out.println(ans);
		}
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
