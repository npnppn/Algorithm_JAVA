package baekjoon;

import java.io.*;
import java.util.*;

//큐 사용해서 없어지는 것들 출력 하면 되는 듯
//K-1번만큼 poll과 offer을 한 뒤, K번 째 값을 poll만하고 해당 원소를 출력
public class Main_11866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		sb.append("<");

		while (q.size() > 1) {
			for (int i = 0; i < k - 1; i++) {
				int result = q.poll(); // K번 쨰 수가 되기 직전까지 맨 앞의 원소를 K-1 번 꺼내오고(poll)
				q.offer(result); // 꺼내온 원소들을 맨 뒤로 넣는다.(offer)
			}

			sb.append(q.poll() + ", "); // K번째로 뽑힌(poll) 원소는 출력
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);

	}

}
