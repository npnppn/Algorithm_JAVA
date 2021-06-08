import java.io.*;
import java.util.*;
// 모든 마을을 순환"하는 것이 목표
//비트마스킹 활용하는건데 아직 많이 어렵다.. 나중에 dp공부하고 다시 또 풀어볼것.
public class Main_2098 {
	public static int N;
	public static int answer = Integer.MAX_VALUE;
	public static int[][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][1 << N];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		dp[0][1] = 0;
		dfs(0, 1);
		System.out.println(answer);
	}

	//모든 마을을 1마킹해보자
	public static void dfs(int now, int visited) {
		if (visited == ((1 << N) - 1)) {
			if (map[now][0] == 0)
				return;
			int compare = dp[now][visited] + map[now][0];
			answer = Math.min(answer, compare);
			return;
		}

		//경로 검증하기
		for (int i = 0; i < N; i++) {
			int next = (1 << i);
			if ((visited | next) == visited) //같으면 이 경로에 next가 들어있는거니까 패스
				continue;
			if (map[now][i] == 0) //경로 없어도 패스
				continue;
			
			//이부분 살짝 이해안됨.. 지금까지 경로 +지금마을에서 다음마을 cost 가 기존 계산된 다음마을까지 경로가 맞으면 dp 대입
			if (dp[now][visited] + map[now][i] < dp[i][visited | next]) {
				dp[i][visited | next] = dp[now][visited] + map[now][i];
				dfs(i, visited | next);
			}
		}
	}
}