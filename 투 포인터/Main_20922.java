package binary_search;

import java.io.*;
import java.util.*;

public class Main_20922 {
//��ĳ�ʷ� ���� ���� �ð��ʰ�. �̷� ������ ���� �׳� ���۵�� �ð�������
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] cnt = new int[100001]; // � ���ڰ� ��� ���̴��� ���� �迭
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// ������ �ϸ� �ȵ���
		// Arrays.sort(arr);

		int left = 0;
		int right = 0;
		int ans = 0;
		while (left <= right) {
			if (right <= N - 1 && cnt[arr[right]] < K) { // k�� �̸��ΰŴ� �κ� ������ ���Եǵ� �Ǵ°Ŵϱ� ǥ��
				cnt[arr[right]]++;
				right++;

			} else if (cnt[arr[right]] == K) { // �� �̻� ���ø��� left�� ����
				cnt[arr[left]]--;
				left++;
			}

			ans = Math.max(ans, right - left); // ��������
			if (right == N)
				break;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		System.out.println(sb);
	}

}
