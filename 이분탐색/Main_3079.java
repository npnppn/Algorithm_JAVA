package binary_search;

import java.io.*;
import java.util.*;

public class Main_3079 {

	static long n, m, max;
	static int[] time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		time = new int[(int) n];
		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(br.readLine());
			max = Math.max(time[i], max);
		}

		Arrays.sort(time);
		biSearch();

	}

	static void biSearch() {
		long start = 1;
		long end = max * m;
		long mid, sum;
		while (start <= end) {
			sum = 0;
			mid = (start + end) / 2;
			for (int i = 0; i < n; i++) {
				sum += mid / time[i];
			}
			if (sum >= m) {
				end = mid - 1;

			} else {
				start = mid + 1;
			}

		}
		System.out.println(start);

	}

}
