package binary_search;

import java.io.*;
import java.util.*;

public class Main_19637 {
	static String[] arr = new String[100001]; // 정보 담는거
	static int[] arr2 = new int[100001]; // 숫자 담는거

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			int value = Integer.parseInt(br.readLine());
			int left = 0;
			int right = n - 1;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (arr2[mid] < value) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			sb.append(arr[left] + "\n");

		}
		System.out.println(sb);

	}

}
