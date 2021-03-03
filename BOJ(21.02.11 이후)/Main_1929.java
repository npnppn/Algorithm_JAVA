package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_1929 {
	public static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		prime = new boolean[N + 1];
		// true = 소수아님 , false = 소수
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			// 이미 체크된 배열이면 다음 반복문으로 skip
			if (prime[i])
				continue;
			
			// i 의 배수들을 걸러주기 위한 반복문
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

		
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			// false = 소수
			if (!prime[i])
				sb.append(i).append('\n');
		}
		System.out.println(sb);
	}
}
