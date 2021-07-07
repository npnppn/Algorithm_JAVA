package a0708;

import java.io.*;
import java.util.*;

public class Main_2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(gcd(a, b));
		System.out.println((a * b) / gcd(a, b));

	}

	static int gcd(int a, int b) {
		int mod;
		while ((mod = a % b) > 0) {
			a = b;
			b = mod;
			mod = a % b;

		}
		return b;

	}
}
