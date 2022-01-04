package greedy;

import java.io.*;
import java.util.*;

public class Main_11000 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] time = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		// 시작하는 순서대로 정렬하고나서 강의실 갯수세기
		Arrays.sort(time, (o1, o2) -> {
			if (o1[0] == o2[0])
				return o1[1] - o2[1]; // 시작시간 같으면 빨리 끝나는 순서대로
			else
				return o1[0] - o2[0]; // 시작하는 시간 순서대로
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (!pq.isEmpty() && pq.peek() <= time[i][0]) {
				pq.poll();
			}
			pq.add(time[i][1]);
		}
		System.out.println(pq.size());

	}

}
