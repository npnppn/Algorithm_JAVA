package dfs_bfs;

import java.io.*;
import java.util.*;
//그리디로 접근할지?? bfs로 해야할지? 고민
public class Main_16953 {

	// 정수와 갯수를 담는 클래스
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
				// 2를 곱하는 경우
				if (i == 0) {
					x = (tmp.k) * 2;
				}
				// 오른쪽에 1 추가하는 경우
				else {
					x = ((tmp.k) * 10) + 1;
				}

				// b까지 아직 다 안왔으면 다시 큐에 넣고 위 작업 반복
				if (b >= x) {
					Point p2 = new Point(x, tmp.cnt+1);
					q.add(p2);
				}

			}

		}
		System.out.println("-1");

	}

}
