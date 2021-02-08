package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D3_9229 {

	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int T = Integer.parseInt(br.readLine()); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 과자 봉지 개수
			int M = Integer.parseInt(st.nextToken()); // 무게 합 제한
			int[] weight = new int[N];
			int weightMax = -1; // 들고갈 방법 없을땐 -1이므로
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken()); // 무게들 배열에 저장
			}

			// 굳이 조합을 안써도 2개만 선택하는 거라 포문으로도 충분하다고 생각했습니다!!
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) { // 모든 무게 탐색
					if (weight[i] + weight[j] <= M) { // 무게 합 조건을 만족하고 최대값 비교
						weightMax = Math.max(weightMax, weight[i] + weight[j]);
					}
				}
			}
			System.out.println("#" + tc + " " + weightMax);
		}
	}
}
