package ssafy_algo;

//맨 처음 색종이는 1로 면적만큼 입력받고, 그 다음 색종이는 2, 3,...N까지 입력받음
//그후에 맵 전체 탐색하여 N개수 있다면 갯수출력
import java.util.*;
import java.io.*;

public class Main_10163 {

	public static void main(String[] args) throws Exception, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[101][101];
		for (int tc = 1; tc <= N; tc++) {
			int a = sc.nextInt(); // x좌표
			int b = sc.nextInt(); // y좌표
			int c = sc.nextInt(); // width
			int d = sc.nextInt(); // height

			for (int i = a; i < a + c; i++) {
				for (int j = b; j < b + d; j++) {
					map[i][j] = tc; // x, y좌표에 테스트케이스만큼 입력
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 0; j < 101; j++) {
				for (int k = 0; k < 101; k++) {
					if (map[j][k] == i) {// 배열에 N개수가 있다면 갯수 출력
						cnt++;
					}
				}

			}
			System.out.println(cnt);
		}
	}
}
