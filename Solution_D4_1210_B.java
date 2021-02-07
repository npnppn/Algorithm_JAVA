package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D4_1210_B {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
		int[] dy = { 1, 0, -1, 0 };
		int x = 0;
		int y = 0;
		int dir = 0; //방향 (우 하 좌 상 으로 가도록)
		int res = 1; //결과값
		for (int tc = 1; tc <= t; tc++) {
			int n = s.nextInt();
			int[][] snail = new int[n][n];
			snail[0][0] = 1;
			while (true) {
				for(int len = 0; len <n; len++) {
					snail[x][y] = res;
					int nx = x + dx[dir];
					int ny = y + dy[dir];
				
				//배열 안에 있고, 값이 0이면 결과값을 1씩 늘려서 출력하면됨
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && snail[nx][ny] == 0) {
					res++;
					x = nx;
					y = ny;
					snail[nx][ny] = res;
				}
					
				
				 else { //인덱스를 벗어나거나 방문한곳 돌아오면 방향 변경
					dir = (dir + 1) % 4;
				}
				
				if (res == n * n)
					break;
			}
			
			System.out.println("#" + tc + " ");
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
			}
		}
	}
}
	