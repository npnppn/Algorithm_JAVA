package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11286 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			int a = Math.abs(o1);
			int b = Math.abs(o2);

			if (a == b)
				return o1 > o2 ? 1 : -1;
			return (a - b);
		});
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number == 0) {
				if (q.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(q.poll());
				}
			}

			//
			else {
				q.offer(number);
			}
		}

	}

}
