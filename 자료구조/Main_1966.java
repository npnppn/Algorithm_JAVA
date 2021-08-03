package data_structure;

import java.io.*;
import java.util.*;

public class Main_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // ������ ����
			int m = sc.nextInt(); // ���° �����ִ��� �˰���� ����
			LinkedList<Integer> ll = new LinkedList<>(); // �켱���� ������
			Queue<Integer> q = new LinkedList<>(); // ������ ť
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
					// �պ��� ū�� ������ Ȯ���ϰ� ��������
					if (ll.peek() < ll.get(i)) {
						check = false;
						break;
					}
				}

				if (!check) { // �Ǿ� ���� �ٽ� �ڷ� ��������
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
