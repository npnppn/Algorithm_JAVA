package im;

import java.io.*;
import java.util.*;

public class Main_11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		while (q.size() > 1) {
			for (int i = 0; i < k - 1; i++) { // k이전까지 다 큐 뒤로 보내야함
				int tmp = q.poll(); // 큐에서 하나 뽑아서
				q.offer(tmp); // 큐 뒤에 추가를해
				// System.out.print(tmp + " ");
			}
			sb.append(q.poll() + ", ");
		}

		sb.append(q.poll() + ">"); // 큐에 남은 한개
		System.out.println(sb);
	}
}
