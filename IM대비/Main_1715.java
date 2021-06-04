package im;

import java.io.*;
import java.util.*;

public class Main_1715 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			pq.add(num);
			// sum += num;
		}
		// System.out.println(sum);
		while (pq.size() > 1) {
			int x1 = pq.poll();
			int x2 = pq.poll();
			sum += (x1 + x2);
			pq.offer(x1 + x2);

		}
		System.out.println(sum);

	}

}
