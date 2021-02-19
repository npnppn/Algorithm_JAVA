package ssafy_algo;

import java.io.*;
import java.util.*;

public class Solution_4012 {
	static int N;
	static int[][] map;
	static int min;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); //테케 수
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 배열 크기
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); //식재료 입력
				}
			}

			min = Integer.MAX_VALUE;
			visited = new boolean[N];
			comb(0, N, N / 2); //N개중에서 N/2개를 고르는 조합
			
			System.out.println("#" + tc + " " + min);
		}
	}

	//조합 코드
	public static void comb(int start, int N, int r) {
		if (r == 0) {
			int result = calculate();
			if (min > result) {
				min = result;
			}
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			comb(i + 1, N, r - 1);
			visited[i] = false;
		}
	}
	
	//밑에 코드처럼 쓰면 조합 안에 순열이 구현된다고함.. 알아두면 좋을 듯
	/* 
	 for (int i = 0; i < N; i++) {
               for (int j = 0; j < N; j++) {
                   if (i == j)
                       continue;
                   if (isSelected[i] && isSelected[j])
                       a += arr[i][j];
                   else if (!isSelected[i] && !isSelected[j])
                       b += arr[i][j];
               }
           }
	 */
	


	public static int calculate() {
		ArrayList<Integer> aList = new ArrayList<>(); //A음식 공간
		ArrayList<Integer> bList = new ArrayList<>(); //B음식 공간

		// 음식 별 식재료 나누기
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				aList.add(i);
			} else
				bList.add(i);
		}

		int a = 0; // A 음식 시너지의 합
		int b = 0; // B 음식 시너지의 합

		// 각 음식의 시너지 합 구하기 -> 이거도 조합으로 구현해야할 수 있을거같은데 잘 안되서 이중포문으로 했다..
		for (int i = 0; i < aList.size() - 1; i++) {
			for (int j = i; j < aList.size(); j++) {
				//A음식 시너지의 합
				a += map[aList.get(i)][aList.get(j)];
				a += map[aList.get(j)][aList.get(i)];

				//B음식 시너지의 합
				b += map[bList.get(i)][bList.get(j)];
				b += map[bList.get(j)][bList.get(i)];
			}
		}

		return Math.abs(a - b);
	}
}