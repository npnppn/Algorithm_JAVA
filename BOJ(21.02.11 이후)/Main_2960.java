package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_2960 {
	public static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		prime = new boolean[N + 1];

		for (int i = 2; i <= N; i++) {
			prime[i] = true;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				if (!prime[j])
					continue;
				prime[j] = false;
				cnt++;

				if (cnt == K) {
					System.out.println(j);
					break;
				}
			}
		}
	}
}
