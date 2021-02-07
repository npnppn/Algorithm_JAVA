package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_BOJ_15649 {
	static int arr[];
	static boolean visit[];
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();

	public static void pick(int count) {
		// pick 함수 탈출 - 뽑은 갯수와 M이 동일할 때
		if (count == M) {
			// StringBuilder 에 뽑은 값(arr) 저장
			for (int i : arr)
				sb.append(i + " ");
			sb.append("\n");
			return;
		}

		// 뽑지않은것은 재귀호출
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true; // 방문 체크
				arr[count] = i; // 뽑기
				pick(count + 1); // 그 다음 값 뽑기위해 재귀호출
				visit[i] = false; // 뽑은 뒤 미방문 처리
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new int[M];
		visit = new boolean[N + 1];
		pick(0);
		System.out.print(sb);
		scan.close();
	}

}
