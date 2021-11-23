package sort;

import java.io.*;
import java.util.*;

public class Main_1715 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long sum = 0;
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			pq.add(num);
		}
		while (pq.size() > 1) {
			long a = pq.poll();
			long b = pq.poll();
			pq.add(a + b);
			sum += (a + b);
		}
		System.out.println(sum);

	}

}
