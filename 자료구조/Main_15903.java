package a0707;

import java.io.*;
import java.util.*;

// 카드를 뽑고 합치고나서 갱신한 뒤에 다시 엎어 씌우기 과정 반복! 가장 작게 만들어야 하니까 우선순위큐.
public class Main_15903 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 카드 갯수
		int m = sc.nextInt();// 카드 합체 몇번 하는지

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			pq.offer(sc.nextLong());
		}

		long cnt = m;
		while (cnt > 0) {
			long a = pq.poll();
			long b = pq.poll();

			long sum = a + b;
			pq.offer(sum); // a자리에
			pq.offer(sum); // b자리에
			cnt--;
		}

		long result = 0; // 최종 점수
		while (!pq.isEmpty()) {
			result += pq.poll();
		}

		System.out.println(result);
	}

}
