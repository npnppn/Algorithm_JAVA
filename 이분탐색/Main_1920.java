package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_1920 {
	static int[] arr2;
	static int[] arr;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 1 2 3 4 5
		//System.out.println(Arrays.toString(arr));

		
		int M = Integer.parseInt(br.readLine());
		arr2 = new int[M];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st2.nextToken());
		}
		// Arrays.sort(arr2); //1 3 5 7 9
		//System.out.println(Arrays.toString(arr2));
		
		
		for (int i = 0; i < M; i++) {
			System.out.println(biSearch(arr, arr2[i]));

		}
	}

	static int biSearch(int[] arr, int num) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] == num) {
				return 1;
			}

			else if (arr[mid] > num) {
				end = mid - 1;
			}

			else {
				start = mid + 1;
			}

		}
		return 0;
	}
}