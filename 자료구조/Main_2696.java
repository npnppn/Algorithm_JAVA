package data_structure;

import java.io.*;
import java.util.*;

public class Main_2696 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			int M = Integer.parseInt(br.readLine()); // �迭ũ��
			int cnt = 0;

			System.out.println((M + 1) / 2); // �߾Ӱ� ����

			for (int i = 0; i < M; i++) {
				// 10�� ������ ����Ű
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}

				int n = Integer.parseInt(st.nextToken());
				// �ִ������� �߾Ӱ����ϸ�
				// �ּ������� �߾Ӱ��̻�
				if (maxHeap.size() == minHeap.size()) {
					maxHeap.offer(n);
				} else {
					minHeap.offer(n);
				}

				// maxHeap���� �߰��� ������ ���� �����ϵ���
				if (!minHeap.isEmpty()) {
					if (maxHeap.peek() > minHeap.peek()) {
						int tmp1 = maxHeap.poll();
						int tmp2 = minHeap.poll();

						maxHeap.offer(tmp2);
						minHeap.offer(tmp1);
					}
				}

				// ¦���϶�
				if (i % 2 == 0) {
					if (cnt == 9 || i == M - 1) {
						System.out.println(maxHeap.peek());
						cnt = 0;
					} else {// Ȧ���϶�
						System.out.print(maxHeap.peek() + " ");
					}
					cnt++;
				}
			}

		}

	}
}