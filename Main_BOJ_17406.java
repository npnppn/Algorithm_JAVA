package ssafy_algo;

import java.util.*;
import java.io.*;

/*  연산을 수행하는 순서 1번
 	회전하는거 2번
 	최소 배열값 출력 3번
 */

public class Main_BOJ_17406 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int m;
	static int n;
	static int k;
	static int[][] arr;
	static int[][] elem;
	static int min = 9999999;
	
	public static void rotate(int r, int c, int s, int[][] arr) {
		for(int i = 0; i < s; i++) {
			int r_min = r - s - 1 + i, r_max = r + s - 1 - i;
			int c_min = c - s - 1 + i, c_max = c + s - 1 - i;
			int x = r_min;
			int y = c_min;
			int d = 0;
			int tmp = arr[x][y];
			while(true) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx > r_max || ny > c_max || nx < r_min || ny < c_min) {
					d++;
					if(d > 3) {
						break;
					}
				}
				else{
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				}
			}
			arr[x][y + 1] = tmp;
		}
	}
	
	public static void dfs(int x, int depth, int[] visit, int[] route) {
		visit[x] = 1;
		route[depth] = x;
		
		if(depth == k - 1) {
			int[][] n_arr = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					n_arr[i][j] = arr[i][j];
				}
			}
			for(int i = 0; i < k; i++) {
				rotate(elem[route[i]][0], elem[route[i]][1], elem[route[i]][2], n_arr);
			}
			
			for(int i = 0; i < n; i++) {
				int sum = 0;
				for(int j = 0; j < m; j++) {
					sum += n_arr[i][j];
				}
				min = Math.min(sum, min);
			}
		}
		
		for(int i = 0; i < k; i++) {
			if(visit[i] == 0) dfs(i, depth + 1, visit, route);
		}
		visit[x] = 0;
		route[depth] = 0;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());
		k = Integer.parseInt(tk.nextToken());
		
		arr = new int[n][m];
		elem = new int[k][3];
		int[] visit = new int[k];
		int[] route = new int[k];
		
		for(int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		for(int i = 0; i < k; i++) {
			tk = new StringTokenizer(br.readLine());
			elem[i][0] = Integer.parseInt(tk.nextToken());
			elem[i][1] = Integer.parseInt(tk.nextToken());
			elem[i][2] = Integer.parseInt(tk.nextToken());
		}
		
		for(int i = 0; i < k; i++) {
			dfs(i, 0, visit, route);
		}
		System.out.println(min);
	}
}
