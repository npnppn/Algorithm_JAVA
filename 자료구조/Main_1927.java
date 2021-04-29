package baekjoon;

import java.util.*;
import java.io.*;

public class Main_1927 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2); // Comparator 삽입
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number == 0) {
				if (q.isEmpty()) { // 큐 비어있다면
					System.out.println(0); // 0출력
				} else { // 큐에 있으면
					System.out.println(q.poll()); // 꺼내
				}
			}
			// 입력받은 값이 0이아니면
			else {
				q.offer(number); // 그 숫자 큐에 집어넣어
			}

		}

	}

}
