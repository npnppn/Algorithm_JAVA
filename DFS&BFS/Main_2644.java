package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2644 {

	static int n;
	static int[][] map;
	static boolean[] isVisited;

	// 사람 정보 담을 클래스
	static class Person {
		int x; // 번호
		int cnt; // 촌수

		public Person(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		isVisited = new boolean[n + 1];
		map = new int[n + 1][n + 1];

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int m = sc.nextInt(); // 부모자식관계 수
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(); // 부모
			int y = sc.nextInt(); // 자식
			map[x][y] = 1;
			map[y][x] = 1; // 두개 연결해주고 bfs로 탐색
		}
		bfs(num1, num2);
	}

	private static void bfs(int start, int end) {
		boolean isFind = false;
		Queue<Person> queue = new LinkedList<>();
		queue.offer(new Person(start, 0));
		isVisited[start] = true;
		while (!queue.isEmpty()) {
			Person person = queue.poll();
			int start2 = person.x;
			if (start2 == end) {
				isFind = true;
				System.out.println(person.cnt);
				break;
			}
			for (int i = 1; i <= n; i++) { // 아직 방문 안하고 관계가 있는 촌수 탐색
				if (!isVisited[i] && map[start2][i] == 1) {
					isVisited[i] = true;
					queue.offer(new Person(i, person.cnt + 1));
				}
			}
		}
		if (!isFind)
			System.out.println(-1);
	}

}
