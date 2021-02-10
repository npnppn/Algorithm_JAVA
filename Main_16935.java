package ssafy_algo;

/*
문제해결 아이디어
 1. 상하 반전의 경우에는 바깥 반복문에 열 인자를,안쪽에서는 두 개의 행 인자를 두고서
 두 개의 행 인자가 양끝에서 부터 좁혀오면서 배열 요소를 교환하고 두 인자가 반전될 때 그만하면된다.
좌우 반전은 반대로 수행

 2. 90도 회전시키기
새로운 배열[c][행 크기 - 1 - r] = 기존 배열[r][c]
새로운 배열[c][기존 배열 행 크기 - 1 - r] = 기존 배열[r][c]
왼쪽으로 돌리려면 새로운 배열[r][c] = 기존 배열[c][기존 배열 행 길이 - 1 - r]

 3. 4분할 회전
1 -> 2 열 += 열 크기 / 2
2 -> 3 행 += 행 크기 / 2
3 -> 4 열 -= 열 크기 / 2
4 -> 1 행 -= 행 크기 / 2
반대 회전은 반대로 수행
*/

import java.util.*;
import java.io.*;

public class Main_16935 {
	static int N, M, R;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 }; // 반시계방향이니까 우상좌하
	static int[] dy = { 1, 0, -1, 0 };
	static List<Integer> op; // 연산자 담겨있는 리스트

	public static void main(String[] args) throws Exception {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

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

		op = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			op.add(Integer.parseInt(st.nextToken()));
		}

		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ㅡㅡ입력파트종료ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		for (int i : op) {
			switch (i) {
			case 1:
				UpdownReverse();
				break;
			case 2:
				LeftRightReverse();
				break;
			case 3:
				RightRotate();
				break;
			case 4:
				LeftRotate();
				break;
			case 5:
				ChangeRotate();
				break;
			case 6:
				ChangeRotate2();
				break;
			default:
				break;
			}
		}

		// 출력
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ㅡㅡ연산자 계산 파트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 1번 연산자, 상하반전
	public static void UpdownReverse() {
		for (int i = 1; i <= arr.length / 2; i++) {
			int[] tmp = arr[i];
			arr[i] = arr[arr.length - i];
			arr[arr.length - i] = tmp;
		}
	}

	// 2번 연산자, 좌우반전
	public static void LeftRightReverse() {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= arr[i].length / 2; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][arr[i].length - j];
				arr[i][arr[i].length - j] = tmp;
			}
		}
	}

	// 3번 연산자, 오른쪽으로 90도 회전
	public static void RightRotate() {
		int[][] tmp = copy(arr);
		N = tmp.length - 1;
		M = tmp[0].length - 1;
		arr = new int[M + 1][N + 1];
		for (int i = 1, j = N; j >= 1; j--, i++) {//N번 실행
			for (int k = 1; k <= M; k++) {
				arr[k][j] = tmp[i][k];
			}
		}
	}

	// 4번 연산자, 왼쪽으로 90도 회전
	public static void LeftRotate() {
		int[][] tmp = copy(arr);
		N = tmp.length - 1;
		M = tmp[0].length - 1;
		arr = new int[M + 1][N + 1];
		for (int i = 1, j = 1; j <= N; j++, i++) { //N번 실행
			for (int k = 1; k <= M; k++) {
				arr[k][j] = tmp[i][M - k + 1];
			}
		}
	}

	// 5번 연산자, N/2 x M/2인 4개 그룹나눠서 1->2 2->3 3->4 4->1
	public static void ChangeRotate() {
		int[][] tmp = copy(arr);
		N = tmp.length - 1;
		M = tmp[0].length - 1;
		// 1 -> 2
		for (int j = 1; j <= N / 2; j++) {
			for (int i = 1; i <= M / 2; i++) {
				arr[j][M / 2 + i] = tmp[j][i];
			}
		}
		// 3 -> 4
		for (int j = N / 2 + 1; j <= N; j++) {
			for (int i = M / 2 + 1; i <= M; i++) {
				arr[j][i - M / 2] = tmp[j][i];
			}
		}

		// 2 -> 3
		for (int j = 1; j <= N / 2; j++) {
			for (int i = M / 2 + 1; i <= M; i++) {
				arr[j + N / 2][i] = tmp[j][i];
			}
		}

		// 4 -> 1
		for (int j = N / 2 + 1; j <= N; j++) {
			for (int i = 1; i <= M / 2; i++) {
				arr[j - N / 2][i] = tmp[j][i];
			}
		}

	}

	// 6번 연산자, N/2 x M/2인 4개 그룹나눠서 1->4 4->3 3->2 2->1
	public static void ChangeRotate2() {
		int[][] tmp = copy(arr);
		N = tmp.length - 1;
		M = tmp[0].length - 1;
		// 1 -> 4
		for (int j = 1; j <= N / 2; j++) {
			for (int i = 1; i <= M / 2; i++) {
				arr[j + N / 2][i] = tmp[j][i];
			}
		}
		// 4 -> 3
		for (int j = N / 2; j <= N; j++) {
			for (int i = 1; i <= M / 2; i++) {
				arr[j][M / 2 + i] = tmp[j][i];
			}
		}
		// 3 -> 2
		for (int j = N / 2 + 1; j <= N; j++) {
			for (int i = M / 2 + 1; i <= M; i++) {
				arr[j - N / 2][i] = tmp[j][i];
			}
		}
		// 2 -> 1
		for (int j = 1; j <= N / 2; j++) {
			for (int i = M / 2 + 1; i <= M; i++) {
				arr[j][i - M / 2] = tmp[j][i];
			}
		}
	}

	// 배열 복사해두는 함수
	static int[][] copy(int[][] arr) {
		int[][] tmp = new int[arr.length][arr[0].length];
		for (int i = 1; i <= arr.length - 1; i++) {
			for (int j = 1; j <= arr[0].length - 1; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		return tmp;
	}
}
