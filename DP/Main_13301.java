package boj;

import java.io.*;
import java.util.*;

//f(n) = f(n-1) + f(n-2)
public class Main_13301 {
	static int N;
	static long answer;
	static long[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new long[100];

		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(fibo(N, arr));
	}

	public static long fibo(int N, long[] arr) {
		if (N == 1)
			return 4;

		return 4 * arr[N - 1] + 2 * arr[N - 2];
	}
}
