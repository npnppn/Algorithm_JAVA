package baekjoon;

import java.io.*;
import java.util.*;

//1에서 3으로 가는 시계방향 거리 n+3 - n 이고 반시계방향은 n+1 - 2.. 이런식

public class Main_2118 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[100001];
		int result = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arr[i + n] = arr[i];
		}

		for (int i = 1; i < 2 * n; i++) {
			arr[i] += arr[i - 1]; // 원형으로 이어져있으니 구간합 배열 길이를 2n만큼 구성
		}

		for (int i = n; i < 2 * n; i++) {
			for (int j = i - n + 1; j < n; j++) {
				result = Math.max(result, Math.min(arr[i] - arr[j], arr[n + j] - arr[i]));
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(result);
		System.out.println(sb);

	}

}
