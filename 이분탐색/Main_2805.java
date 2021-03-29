package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_2805 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, arr[i]);
		}

		Arrays.sort(arr);

		int result = 0;

		while (start <= end) {
			long total = 0;
			int mid = (start + end) / 2;
			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					total += arr[i] - mid;
				}

			}

			//합계가 원하는 길이보다 작은 경우 왼쪽 부분을 탐색하고, 큰 경우 오른쪽 부분을 탐색하고 mid값을 결과 변수에 넣어준다.
			if (total < M) {
				end = mid - 1;
			} else {
				start = mid + 1;
				result = mid;
			}
		}

		System.out.println(result);
	}
}
