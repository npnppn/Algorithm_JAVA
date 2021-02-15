package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_2961 {
	private static int N;
	private static int c;
	private static int[] sour;
	private static int[] bitter;
	private static int[] arr; // nCi를 구하고 인덱스를 담을 배열
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 재료의 갯수
		sour = new int[N];
		bitter = new int[N];
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) { // n개 중에서 i개를 고르는 조합
			c = i;
			combi(0, 0);
		}

		System.out.println(min);
	}

	private static void combi(int cnt, int index) {
		if (c == cnt) {
			int sum = 0; // 신 맛은 더할거고
			int mul = 1; // 쓴 맛은 곱할거임
			for (int i = 0; i < c; i++) {
				mul *= sour[arr[i]];
				sum += bitter[arr[i]];
			}
			
			// 신맛과 쓴 맛의 차이 구하기
			if (sum > mul) {
				min = Math.min(min, sum - mul);
			} else {
				min = Math.min(min, mul - sum);
			}

			return;
		}

		for (int i = index; i < N; i++) {
			arr[cnt] = i;
			combi(cnt + 1, i + 1);
		}

	}

}
