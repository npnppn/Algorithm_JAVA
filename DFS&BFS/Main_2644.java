package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_2644 {

	static int n;
	static int[][] map;
	static boolean[] isVisited;

	// ��� ���� ���� Ŭ����
	static class Person {
		int x; // ��ȣ
		int cnt; // �̼�

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
		int m = sc.nextInt(); // �θ��ڽİ��� ��
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt(); // �θ�
			int y = sc.nextInt(); // �ڽ�
			map[x][y] = 1;
			map[y][x] = 1; // �ΰ� �������ְ� bfs�� Ž��
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
			for (int i = 1; i <= n; i++) { // ���� �湮 ���ϰ� ���谡 �ִ� �̼� Ž��
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
