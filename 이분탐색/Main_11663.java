package binary_search;

import java.io.*;
import java.util.*;

//정렬해서 이분탐색. 전체 점들의 개수에서 최솟값보다 작은 점과 최댓값보다 큰 점의 개수를 빼야
public class Main_11663 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] point = new int[N];

		for (int i = 0; i < N; i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(point);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int sum = M;

			int left = 0;
			int right = N - 1;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (point[mid] >= a)
					right = mid - 1;
				else
					left = mid + 1;
			}

			sum -= left;
			right = N - 1;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (point[mid] > b)
					right = mid - 1;
				else
					left = mid + 1;
			}
			sum -= (M - left);
			System.out.println(sum);
		}
	}
}