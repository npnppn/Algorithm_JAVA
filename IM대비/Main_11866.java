import java.io.*;
import java.util.*;

public class Main_11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			q.offer(i); //1부터 7까지 일단 다 집어넣어
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while (q.size() > 1) {
			//K번째 사람을 제거하기 위해 k 이전까지 것들을 뒤로 보내버려
			for (int i = 0; i < k - 1; i++) {
				int res = q.poll(); //뽑아서
				q.offer(res); //뒤로 보내
			}
			sb.append(q.poll() + ", "); //이제 너 차례야

		}
		sb.append(q.poll() + ">"); //큐에 마지막 남은 원소 한개까지 꺼내서 요세푸스로 완성!
		System.out.println(sb);
	}

}
