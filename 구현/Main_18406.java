package dongbina;

import java.io.*;
import java.util.*;

public class Main_18406 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		String s = String.valueOf(N);
		int sum1 = 0;
		int sum2 = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (i < len / 2) {
				sum1 += s.charAt(i) - '0';
			} else {
				sum2 += s.charAt(i) - '0';
			}

		}

		if (sum1 == sum2) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}

	}
}
