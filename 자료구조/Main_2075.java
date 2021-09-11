package data_structure;

import java.io.*;
import java.util.*;

public class Main_2075 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}

		// System.out.println(pq);
		// �켱����ť ���������������ϱ� ���ʴ�� �����ٰ� N��°�Ǹ� ���
		int cnt = 0;
		while (cnt < N) {
			int tmp = pq.poll();
			cnt++;
			if (cnt == N) {
				System.out.println(tmp);
			}

		}

	}
}
