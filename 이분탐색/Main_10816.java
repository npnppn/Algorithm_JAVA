package binary_search;

import java.io.*;
import java.util.*;

//스캐너랑 이분탐색 일반적인 방법으로 하니까 시간초과 계속뜸..
//구글링으로 upper랑 lower로 나눠야함을 배움
public class Main_10816 {
	static int[] arrN;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		arrN = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrN.length; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append((upper_bound(num) - (lower_bound(num)) + " "));
		}
		System.out.println(sb);
	}

	static int lower_bound(int num) {
		int start = 0, last = arrN.length, mid;
		while (start < last) {
			mid = start + (last - start) / 2;
			if (num <= arrN[mid]) {
				last = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	static int upper_bound(int num) {
		int start = 0, last = arrN.length, mid;
		while (start < last) {
			mid = start + (last - start) / 2;
			if (num >= arrN[mid])
				start = mid + 1;
			else
				last = mid;
		}
		return start;
	}
}