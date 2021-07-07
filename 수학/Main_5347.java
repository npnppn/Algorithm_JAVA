package a0708;

import java.io.*;
import java.util.*;

public class Main_5347 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			long a = sc.nextLong();
			long b = sc.nextLong();

			System.out.println((a * b) / gcm(a, b));

		}
	}

	// 최대공약수
	static long gcm(long a, long b) {
		long mod;
		while ((mod = a % b) > 0) {
			a = b;
			b = mod;
			mod = a % b;
		}
		return b;
	}

}
