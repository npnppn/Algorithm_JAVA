package ssafy_algo;

import java.util.*;
import java.io.*;
//그냥 제한 칼로리 이하로만 맞추면 되니까 부분집합으로 풀면될듯?

public class Solution_D3_5215 {
	static int n, l;
	static int[] score, calory;
	static int maxScore;
	static boolean[] visited;

	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 재료의 수
			l = Integer.parseInt(st.nextToken()); // 제한 칼로리
			maxScore = 0;
			// 재료에 대한 맛의 점수 score와 칼로리 calory를 배열에 집어넣음
			score = new int[n];
			calory = new int[n];
			visited = new boolean[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				calory[i] = Integer.parseInt(st.nextToken());
			}

			// 제한 칼로리 이하의 조합 중에서 가장 맛에 대한 점수가 높은 햄버거의 점수 출력
			// 같은 재료를 여러번 사용할 수 없음.

			powerset(0);
			System.out.println("#" + tc + " " + maxScore);
		}

		br.close();
	}

	//재귀함수 돌면서 부분집합 원소 추가 확인
	public static void powerset(int idx) {
		//전체 재료 수만큼 다 탐색하기
		if (idx == n) {
			int allScore = 0;
			int allCalory = 0;
			
			for (int i = 0; i < n; i++) {
				// 부분집합 원소인것들끼리만 계산
				if (visited[i]) {
					allScore += score[i];
					allCalory += calory[i];
				}
			}

			// 제한 칼로리 이하일때만 점수를 비교해봄
			if (allCalory <= l) {
				maxScore = Math.max(allScore, maxScore);
			}
		}
		//다 탐색 안했으면
		else {
			// 부분집합인거 표시
			visited[idx] = true;
			powerset(idx + 1);

			// 부분집합 아닌거 표시
			visited[idx] = false;
			powerset(idx + 1);
		}
	}
}
