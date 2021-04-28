package baekjoon; //기본적인 큐 연산을 구현해보는 문제 -> 어떻게하면 마지막 값을 뽑을지가 고민했음.. 큐로는 맨 뒤원소를 못가져옴

import java.io.*;
import java.util.*;

public class Main_18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>(); // 데큐 선언

		int last = 0; // 마지막값을 계산하려고 만든 변수
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {

			case "push": // 정수 x를 큐에 넣음
				int tmp = Integer.parseInt(st.nextToken());
				last = tmp; // 푸시할때마다 값을 저장해주면 마지막에 남아 있는 값이 최종값
				q.offer(tmp);
				break;

			case "pop": // 큐 가장 앞에꺼 빼는거
				if (!q.isEmpty())
					sb.append(q.poll()).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			case "size": // 개수
				sb.append(q.size()).append("\n");
				break;

			case "empty": // 비어있지 않으면, 0 아니면 1
				if (!q.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
				break;

			case "front": // 가장 앞에 있는 정수
				if (!q.isEmpty())
					sb.append(q.peek()).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			case "back": // 가장 뒤에 있는 정수
				if (!q.isEmpty())
					sb.append(last).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			}
		}
		
		System.out.println(sb);
	}
}