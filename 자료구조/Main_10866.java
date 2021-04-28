package baekjoon;

//덱을 구현해보자!
import java.io.*;
import java.util.*;

public class Main_10866 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {

			case "push_front": // 정수 x를 덱 앞에 넣음
				dq.offerFirst(Integer.parseInt(st.nextToken()));
				break;

			case "push_back": // 정수 x를 덱 뒤에 넣음
				dq.offerLast(Integer.parseInt(st.nextToken()));
				break;

			case "pop_front": // 덱 가장 앞의 수 빼는
				if (!dq.isEmpty())
					sb.append(dq.pollFirst()).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			case "pop_back": // 덱 가장 뒤의 수 빼는
				if (!dq.isEmpty())
					sb.append(dq.pollLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			case "size": // 개수
				sb.append(dq.size()).append("\n");
				break;

			case "empty": // 비어있지 않으면, 0 아니면 1
				if (!dq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
				break;

			case "front": // 가장 앞에 있는 정수
				if (!dq.isEmpty())
					sb.append(dq.peek()).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			case "back": // 가장 뒤에 있는 정수
				if (!dq.isEmpty())
					sb.append(dq.peekLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			}
		}

		System.out.println(sb);

	}

}
