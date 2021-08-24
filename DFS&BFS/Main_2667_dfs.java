package dfs_bfs;

import java.util.*;
import java.io.*;

public class Main_2667 {
	static int n;
	static int cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] apt;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		map = new int[n][n]; //����
		visited = new boolean[n][n];
		apt = new int[n * n]; //���� ���� ���� ������ ����
		cnt = 0; //�� ������

		// ��ü �簢�� �Է� �ޱ�
		for (int i = 0; i < n; i++) {
			String input = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		
		//�̺κ��� ���Ծ���. ������������ �����϶������� ��Ʈ�ϰ� ���
		Arrays.sort(apt);
		
		System.out.println(cnt); //�� ���������� ����ϰ�
		for (int i = 0; i < apt.length; i++) {
			if (apt[i] != 0) {
				System.out.println(apt[i]); //0 �ƴѺκ��� ä�����ִ°Ŵϱ� ���ʴ�� ���
			}
		}
	}

	static void dfs(int a, int b) {
		visited[a][b] = true;
		apt[cnt]++;

		for (int i = 0; i < 4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}
}
