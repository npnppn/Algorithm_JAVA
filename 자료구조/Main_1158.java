package data_structure;

import java.io.*;
import java.util.*;

public class Main_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			q.offer(i + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		// k번째 전까지는 꺼내서 뒤로 보내버리고 이 작업 반복
		while (q.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll() + ", ");
		}
		
		sb.append(q.poll() + ">");
		System.out.println(sb);
	}
}