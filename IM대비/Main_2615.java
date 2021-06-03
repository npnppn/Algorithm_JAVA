import java.io.*;
import java.util.*;

public class Main_2615 {
	static int map[][] = new int[19][19];
	static int dir[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };// 오른쪽대각선,오른쪽,아래대각선,아래
	static int result = 0, resultx = -1, resulty = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 1 || map[i][j] == 2)
					go(i, j);
				if (result != 0) {
					System.out.println(result);
					System.out.println(resultx + " " + resulty);
					return;
				}
			}
		}
		System.out.println(result);
	}

	public static void go(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int x1 = x;
			int y1 = y;
			boolean s = true;
			for (int j = 0; j < 5; j++) {
				if (x1 < 0 || x1 >= 19 || y1 < 0 || y1 >= 19 || map[x][y] != map[x1][y1]) {
					s = false;
					break;
				}
				x1 += dir[i][0];
				y1 += dir[i][1];
			}
			
			//각 돌의 지점에서 시작점을 포함해 5번을 이동하면서 이동한 지점의 돌이 같을경우 빨간 네모 부분을 실행해주게 되고 
			//if문을 통해 시작점 이전의 돌과 이후의 돌이 시작점과 색이 다르다면 결과를 출력
			if (s == true) {
				if ((x1 < 0 || x1 >= 19 || y1 < 0 || y1 >= 19 || map[x][y] != map[x1][y1])
						&&
					(x - dir[i][0] < 0 || x - dir[i][0] >= 19 || y - dir[i][1] < 0 || y - dir[i][1] >= 19
						|| map[x][y] != map[x - dir[i][0]][y - dir[i][1]])) {
					result = map[x][y];
					resultx = x + 1;
					resulty = y + 1;
				}

			}

		}
	}

}