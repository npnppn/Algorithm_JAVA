package ssafy_algo;

import java.util.*;

public class Main_1389 {
	static int n;
	static int[][] map;
	static int[][] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //유저의 수
		map = new int[n + 1][n + 1];
		d = new int[n +1][n + 1];
		int e = sc.nextInt();
		int min = 9999999;
		int idx = 0;
		
		//친구관계면 map에서 1로 만들어줌
		for(int i = 1; i <= e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			bfs(i);
		}
		
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			for(int j = 1; j <= n; j++) {
				sum += d[i][j];
			}
			if(sum < min) {
				min = sum;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}
	
	
	//
	public static void bfs(int x) {
		Queue <Integer> q = new LinkedList<Integer>();
		boolean[] visit = new boolean[n + 1];
		for(int i = 1; i <= n; i++) {
			//1이 있으면
			if(map[x][i] == 1) {
				//방문처리 해주고
				visit[i] = true;
				d[x][i] = 1;
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int y = q.poll();
			
			for(int i = 1; i <= n; i++) {
				if(map[y][i] == 1 && visit[i] == false) {
					q.add(i);
					d[x][i] = d[x][y] + 1;
					visit[i] = true;
				}
			}
		}
	}
	
	
}