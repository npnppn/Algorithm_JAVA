package swea;
/* 큰 흐름은 알겠는데 완전히 구현을 다 못했다.. 다음주에 한번 더 풀어보자
1. 구슬 떨어뜨리기
   (구슬은 좌, 우로만 움직일 수 있어서 항상 맨 위에 있는 벽돌만 깨트릴 수 있다.)
2. 벽돌은 숫자 1 ~ 9 로 표현되며, 구술이 명중한 벽돌은 상하좌우로 ( 벽돌에 적힌 숫자 - 1 ) 칸 만큼 같이 제거
   (구슬의 영향을 받은 벽돌 깨뜨리기)
3. 제거되는 범위 내에 있는 벽돌은 동시에 제거
4. 빈 공간이 있으면 벽돌은 밑으로 떨어지게 된다.
result. 남은 벽돌의 개수 구하기
*/
import java.io.*;
import java.util.*;

public class Solution_5656 {

	// Queue에 넣을 객체 좌표 값과 벽돌이 깨질 때 범위를 필드로 가지고 있다.
	static class Brick {
		int h, w, range;

		public Brick(int h, int w, int range) {
			this.h = h;
			this.w = w;
			this.range = range;
		}
	}

	static Queue<Brick> q;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	static int[] spots;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	static int T, N, W, H;

	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		T = stoi(br.readLine());

		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			W = stoi(st.nextToken());
			H = stoi(st.nextToken());

			q = new LinkedList<>();
			spots = new int[N];
			map = new int[H][W];
			ans = Integer.MAX_VALUE;

			for (int h = 0; h < H; ++h) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; ++w) {
					map[h][w] = stoi(st.nextToken());
				}
			}

			makeSet(0);

			System.out.println("#" + t + " " + ans);

		}
	}

	// spots를 지정해주는 함수
	private static void makeSet(int spot) {
		if (spot == N) {
			// 벽돌 선별 및 부시기
			int[][] copy = copyMap();
			int brick = 0;

			for (int i = 0; i < N; ++i) {
				visited = new boolean[H][W];
				selectAndCresh(copy, spots[i]);
				compact(copy);
			}

			brick = count(copy);
			// 현재 남은 벽돌 수와 지금까지 가장 적게 남은 벽돌수를 비교해 ans 갱신
			ans = ans > brick ? brick : ans;

			return;
		}

		for (int w = 0; w < W; ++w) {
			spots[spot] = w;
			makeSet(spot + 1);
		}
	}

	// 남은 벽돌 개수를 세어보는 함수
	private static int count(int[][] copy) {
		int brick = 0;

		for (int h = 0; h < H; ++h) {
			for (int w = 0; w < W; ++w) {
				if (copy[h][w] > 0)
					brick++;
			}
		}
		return brick;
	}

	// 벽돌이 부셔진 이후에 벽돌을 바닥으로 몰아넣는 함수
	private static void compact(int[][] copy) {
		Queue<Integer> temp;

		for (int w = 0; w < W; ++w) {
			temp = new LinkedList<>();

			for (int h = H - 1; h >= 0; --h) {
				if (copy[h][w] > 0)
					temp.offer(copy[h][w]);
			}

			for (int h = H - 1; h >= 0; --h) {
				if (!temp.isEmpty()) {
					copy[h][w] = temp.poll();
				} else {
					copy[h][w] = 0;
				}
			}
		}
	}

	// 구슬과 부딪혔거나 연쇄반응을 일으킨 벽돌을 찾아 부시는 함수
	private static void selectAndCresh(int[][] copy, int spot) {
		// spot에서 떨어진 구슬이 가장 처음 만나는 벽돌을 찾는 부분
		for (int h = 0; h < H; ++h) {
			if (copy[h][spot] > 0) {
				q.offer(new Brick(h, spot, copy[h][spot]));
				break;
			}
		}

		while (!q.isEmpty()) {
			Brick now = q.poll();
			int nh, nw;

			for (int d = 0; d < 4; ++d) {
				for (int r = 0; r < now.range; ++r) {
					nh = now.h + dir[d][0] * r;
					nw = now.w + dir[d][1] * r;

					if (nh >= 0 && nh < H && nw >= 0 && nw < W && !visited[nh][nw]) {
						visited[nh][nw] = true;
						q.offer(new Brick(nh, nw, copy[nh][nw]));
						copy[nh][nw] = 0;
					}
				}
			}
		}
	}

	private static int[][] copyMap() {
		int[][] arr = new int[H][W];

		for (int h = 0; h < H; ++h) {
			for (int w = 0; w < W; ++w) {
				arr[h][w] = map[h][w];
			}
		}

		return arr;
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

}