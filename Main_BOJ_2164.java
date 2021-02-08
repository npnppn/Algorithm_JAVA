package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_BOJ_2164 {

	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		while (q.size() != 1) {
			//int first = q.poll();
			int second = q.poll();
			q.offer(second);
		}
		
		System.out.println(q.poll());
	}

}
