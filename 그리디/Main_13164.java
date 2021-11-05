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
		// 1�� ��ġ�� n-1�� �׷쳲��, 2����ġ�� n-2�� �׷쳲��... �׷� n-k�� ��ġ�� n�� �׷��� ����!
		// ó���� n % k �� �����ؼ� ��ü��? �����غôµ� n-k �� �ùٸ� �����̾���..!
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
