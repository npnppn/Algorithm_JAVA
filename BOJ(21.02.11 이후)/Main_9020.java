package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9020 {
	static boolean[] prime = new boolean[10001];

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		primecheck();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int first = n / 2;
			int second = n / 2;

			// 10 이라하면 5 5로 나눠서 앞꺼는 줄이고 뒤꺼는 늘리면서 확인해감. 이렇게 하면 차이 가장 작은거로 나오갰지
			while (true) {

				// 두 파티션이 모두 소수일 경우는 바로 출력
				if (!prime[first] && !prime[second]) {
					System.out.println(first + " " + second);
					break;
				}
				first--;
				second++;
			}

		}
	}

	// 에라토스테네스 체
	static void primecheck() {
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;

			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

	}

}
