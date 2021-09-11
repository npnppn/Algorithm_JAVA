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
			int M = Integer.parseInt(br.readLine()); // 배열크기
			int cnt = 0;

			System.out.println((M + 1) / 2); // 중앙값 개수

			for (int i = 0; i < M; i++) {
				// 10개 넘으면 엔터키
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}

				int n = Integer.parseInt(st.nextToken());
				// 최대힙에는 중앙값이하만
				// 최소힙에는 중앙값이상만
				if (maxHeap.size() == minHeap.size()) {
					maxHeap.offer(n);
				} else {
					minHeap.offer(n);
				}

				// maxHeap에는 중간값 이하의 수만 존재하도록
				if (!minHeap.isEmpty()) {
					if (maxHeap.peek() > minHeap.peek()) {
						int tmp1 = maxHeap.poll();
						int tmp2 = minHeap.poll();

						maxHeap.offer(tmp2);
						minHeap.offer(tmp1);
					}
				}

				// 짝수일때
				if (i % 2 == 0) {
					if (cnt == 9 || i == M - 1) {
						System.out.println(maxHeap.peek());
						cnt = 0;
					} else {// 홀수일때
						System.out.print(maxHeap.peek() + " ");
					}
					cnt++;
				}
			}

		}

	}
}