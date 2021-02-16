package ssafy_algo;

/*최저온도를 기준으로 오름차순 정렬하고,
냉장고내 화학물질들의 최고온도(min) > 현재 화학물질 최저온도이면 -> 같은냉장고 가능
 화학물질 다 넣으면 반복문 종료하면 될듯? 

문제 이해하는데 좀 오래걸림
*/

import java.io.*;
import java.util.*;

public class Main_1828 {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());// 화학 물질의 수
		int[][] m = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m[i][0] = Integer.parseInt(st.nextToken()); // 최저 보관온도
			m[i][1] = Integer.parseInt(st.nextToken()); // 최고 보관온도
		}

		// 2차원 배열 정렬 -> 이부분 아직 잘 몰라서 다른 팀원의 도움을 받음.. 알아두기!!!
		Arrays.sort(m, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] < b[0] ? -1 : 1;
			}
		});

		
		int max = Integer.MIN_VALUE; //최댓값 변수
		int answer = 0; // 냉장고 수
		
		for (int i = 0; i < N; i++) {
			if (m[i][1] <= max) { // 최고 보관온도들 중에서 냉장고 포함 가능하면
				max = m[i][1]; // 그게 바로 최선의 온도
			}
			else {
				if (m[i][0] <= max) { // 최저 보관온도들 중에서 냉장고 포함 가능하면 다음으로 넘어가
					continue;
				}
				else { // 냉장고 포함 불가능하면 갯수 하나 늘리고, 그 온도가 최선의 온도
					answer++;
					max = m[i][1];
				}
			}
		}
		
		System.out.println(answer); //냉장고 갯수 출력
	}
}
