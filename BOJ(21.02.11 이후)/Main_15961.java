package baekjoon;

import java.io.*;
import java.util.*;

/*
1. 첫 번째 스시부터 K개의 스시를 덱에 집어넣고 종류를 셉니다.
2. N - 1번 반복문을 돌리면서 맨 앞에 있는 스시를 빼고 다음 스시를 덱에 집어넣습니다.
i) 뺀 스시의 종류가 덱에 더 이상 없을 경우 cnt를 빼줍니다
ii) 집어 넣은 스시의 종류가 기존 덱에 존재하지 않았을 경우 cnt를 더해줍니다
iii) 덱에 쿠폰으로 제공되는 스시의 종류가 없을 경우 cnt를 하나 더해줍니다.
3. 1, 2번에서 구한 값들 중 최대를 출력해줍니다.
회전초밥집이기 때문에 더해주는 스시 인덱스를 (i+K)%N으로 해주는 것이 핵심!
 */

public class Main_15961 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] s = new int[3001];
		int[] sushi = new int[N];

		for (int i = 0; i < N; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		System.out.println(solve(sushi, s, k, c));
	}

	public static int solve(int[] sushi, int[] s, int k, int c) {
		int answer = 0;
		int cnt = 1;
		s[c]++;
		for (int i = 0; i < k; i++) {
			if (s[sushi[i]] == 0)
				cnt++;
			s[sushi[i]]++;
		}

		for (int i = 0; i < sushi.length; i++) {
			if (s[sushi[(i + k) % sushi.length]] == 0)
				cnt++;
			s[sushi[(i + k) % sushi.length]]++;

			s[sushi[i]]--;
			if (s[sushi[i]] == 0)
				cnt--;
			answer = Math.max(answer, cnt);
		}
		return answer;
	}

}