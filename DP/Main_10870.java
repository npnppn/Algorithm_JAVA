package dp;

import java.io.*;
import java.util.*;

public class Main_10870 {
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(fibo(n));

	}

	static int fibo(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fibo(n - 1) + fibo(n - 2);

	}

}
