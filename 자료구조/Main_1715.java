import java.io.*;
import java.util.*;
//앞 2개를 더한 값을 뒤에서 곧바로 사용하므로 더한 값을 큐에 계속 넣어줘야한다.
//최소한의 비교를 하기 위해서는 낮은 값부터 먼저 더해야 하므로
//오름차순으로 정렬된 상태에서 값을 더하기 위해 우선순위 큐 사용! 

public class Main_1715 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		for (int i = 0; i < n; i++) {
			pq.add(sc.nextLong());
		}
		long sum = 0;

		while (pq.size() > 1) { // 2개 이상 들어가있어야 비교가능
			long tmp = pq.poll(); // 맨 처음꺼 꺼내고
			long tmp2 = pq.poll(); // 그다음꺼 꺼내서

			sum += tmp + tmp2; // 더하고
			pq.add(tmp + tmp2); // 그 더한것들을 다시 넣어
		}

		StringBuilder sb = new StringBuilder();
		sb.append(sum);
		System.out.println(sb);

	}

}
