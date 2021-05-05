package baekjoon;

import java.io.*;
import java.util.*;

public class Main_3273 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int left = 0;
		int right = n - 1;
		while (left < right) {
			if (arr[left] + arr[right] >= x) {
				if (arr[left] + arr[right] == x)
					cnt++;
				right--;

			} else {
				left++;
			}
		}

		System.out.println(cnt);

	}

}
