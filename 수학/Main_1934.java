package a0708;

import java.io.*;
import java.util.*;

public class Main_1934 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println((a * b) / gcd(a, b));
		}

	}

	static int gcd(int a, int b) {
		while (b != 0) {
			int mod = a % b;
			a = b;
			b = mod;

		}
		return a;
	}

}
