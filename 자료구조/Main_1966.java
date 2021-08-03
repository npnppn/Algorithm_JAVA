package data_structure;

import java.io.*;
import java.util.*;

public class Main_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // 문서의 개수
			int m = sc.nextInt(); // 몇번째 놓여있는지 알고싶은 문서
			LinkedList<Integer> ll = new LinkedList<>(); // 우선순위 담을거
			Queue<Integer> q = new LinkedList<>(); // 프린터 큐
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				ll.add(sc.nextInt());
			}

			for (int i = 0; i < n; i++) {
				if (i == m)
					q.add(m);
				else
					q.add(101);
			}

			while (!ll.isEmpty()) {
				boolean check = true;
				for (int i = 0; i < ll.size(); i++) {
					// 앞보다 큰거 있으면 확인하고 빠져나가
					if (ll.peek() < ll.get(i)) {
						check = false;
						break;
					}
				}

				if (!check) { // 맨앞 빼고 다시 뒤로 보내버려
					ll.add(ll.poll());
					q.add(q.poll());
				} else {
					ll.poll();
					cnt++;
					if (q.peek() == m) {
						System.out.println(cnt);
					}
					q.poll();
				}

			}

		}

	}

}
