package greedy;

import java.io.*;
import java.util.*;

public class Main_13164 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] minus = new int[n - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n - 1; i++) {
			minus[i] = arr[i + 1] - arr[i];
		}

		Arrays.sort(minus);
		// 1번 합치면 n-1개 그룹남고, 2번합치면 n-2개 그룹남고... 그럼 n-k번 합치면 n개 그룹이 남지!
		// 처음엔 n % k 로 생각해서 전체를? 생각해봤는데 n-k 가 올바른 접근이었다..!
		int divide = n - k;
		int total = 0;
		for (int i = 0; i < divide; i++) {
			total += minus[i];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(total);
		System.out.println(sb);

	}

}
