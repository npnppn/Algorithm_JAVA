package ssafy_algo;
import java.io.*;
import java.util.*;

public class Main_10157 {
	static int dx[] = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int dy[] = { 0, 1, 0, -1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(); //가로
		int R = sc.nextInt(); //세로
		int K = sc.nextInt(); //대기번호
		int map[][] = new int[R][C]; 
		
		//좌석 배정 불가능하면 0출력하고 종료
		if (R * C < K) {
			System.out.println(0);
			return;
		}
		
		//시작점 설정(맨 왼쪽밑부터 시작해서 올라오니까)
		int cnt = 1;
		int x = R - 1;
		int y = 0;
		int dir = 0;
		
		while (cnt != K) { //K랑 cnt랑 같아지면 그 순간의 좌표 출력하면됨
			map[x][y] = cnt; //왼쪽 밑이 1부터 시작
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			//내부에 있으면 상 우 하 좌 순서로 움직임
			if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != 0) {
				dir++;
				if (dir == 4) dir = 0;
				nx = x + dx[dir];
				ny = y + dy[dir];
			}

			x = nx;
			y = ny;
			cnt++;
		}
		System.out.print((y + 1) + " " + (R - x)); //0,0을 기준으로 생각했으니까 y+1 , R-x로 해야 정답이 나옴

	}
}
