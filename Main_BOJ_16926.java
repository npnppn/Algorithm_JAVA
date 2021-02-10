package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_BOJ_16926 {

	private static int N, M, R;
	private static int[][] arr;

	private static int[] dx = { 0, 1, 0, -1 }; // 반시계방향이니까 우상좌하
	private static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken()); // 회전의 수

		arr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num = Math.min(N, M) / 2; // 총 돌려야 하는 네모 개수
		//회전하는부분
		for (int k = 0; k < R; k++) {
			for (int i = 1; i <= num; i++) {
				// 네모들의 왼쪽 맨위의 좌표는 1,1 || 2,2 || 3,3 || ...
				int x = i; //시작점은 왼쪽 위!
				int y = i;
				int temp = arr[x][y]; // 첫번째 값을 담아놓고 연산 후에 넣어줌.
				int dir = 0;

				while (dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (nx < i || ny < i || nx > N - i + 1 || ny > M - i + 1) {
						dir++; //사각형 벗어나면 방향전환
					} else { //벗어나지 않으면 진행
						arr[x][y] = arr[nx][ny]; //이전 점의 값을 다음점 값으로 바꿈
						x = nx;
						y = ny;
					}
				}
				
				arr[i + 1][i] = temp; //4방향 다 연산하면 처음에 빼놓았던 값을 한 행 밑에 넣어눔(1,1 -> 2,1로 이동했기 때문)
			}
		}

		//출력 부분
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
