package class3;

import java.io.*;
import java.util.*;

public class Main_1003 {
	static int t;
	static int[] zero;
	static int[] one;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());

			fibo(n);
			System.out.println(zero[n] + " " + one[n]);

		}
	}

	static void fibo(int n) {
		zero = new int[41];
		one = new int[41];

		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;

		for (int i = 2; i < 41; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}

	}
}
