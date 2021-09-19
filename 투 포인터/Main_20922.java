package binary_search;

import java.io.*;
import java.util.*;

public class Main_20922 {
//스캐너로 쓰니 역시 시간초과. 이런 유형은 이제 그냥 버퍼드로 시간줄이자
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] cnt = new int[100001]; // 어떤 숫자가 몇번 쓰이는지 담을 배열
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬을 하면 안되지
		// Arrays.sort(arr);

		int left = 0;
		int right = 0;
		int ans = 0;
		while (left <= right) {
			if (right <= N - 1 && cnt[arr[right]] < K) { // k번 미만인거는 부분 수열에 포함되도 되는거니까 표시
				cnt[arr[right]]++;
				right++;

			} else if (cnt[arr[right]] == K) { // 더 이상 못늘리면 left를 땡김
				cnt[arr[left]]--;
				left++;
			}

			ans = Math.max(ans, right - left); // 수열길이
			if (right == N)
				break;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		System.out.println(sb);
	}

}
