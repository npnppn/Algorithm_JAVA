package baekjoon;

import java.io.*;
import java.util.*;

public class Main_4948 {
	static boolean[] prime = new boolean[(123456 * 2) + 1]; // 최댓값

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		primecheck();
		
		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;
			int cnt = 0;

			for (int i = n + 1; i <= 2 * n; i++) {
				if (!prime[i]) {
					cnt++;
				}
			}
			System.out.println(cnt);

		}

	}

	// 에라토스테네스 체
	static void primecheck() {
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]==true)
				continue;

			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}

		}

	}

}
