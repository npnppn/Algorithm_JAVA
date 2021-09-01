package dfs_bfs;

import java.io.*;
import java.util.*;
//�׸���� ��������?? bfs�� �ؾ�����? ���
public class Main_16953 {

	// ������ ������ ��� Ŭ����
	static class Point {
		long k;
		long cnt;

		Point(long k, long cnt) {
			this.k = k;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		bfs(a, b);
	}

	static void bfs(long a, long b) {
		Queue<Point> q = new LinkedList<Point>();
		Point p = new Point(a, 0);
		q.add(p);
		while (!q.isEmpty()) {
			Point tmp = q.poll();
			if (tmp.k == b) {
				System.out.println(tmp.cnt + 1);
				return;
			}

			for (int i = 0; i < 2; i++) {
				long x = 0;
				// 2�� ���ϴ� ���
				if (i == 0) {
					x = (tmp.k) * 2;
				}
				// �����ʿ� 1 �߰��ϴ� ���
				else {
					x = ((tmp.k) * 10) + 1;
				}

				// b���� ���� �� �ȿ����� �ٽ� ť�� �ְ� �� �۾� �ݺ�
				if (b >= x) {
					Point p2 = new Point(x, tmp.cnt+1);
					q.add(p2);
				}

			}

		}
		System.out.println("-1");

	}

}
