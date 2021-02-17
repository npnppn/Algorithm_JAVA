package ssafy_algo;
/*
 치킨집과 고객들의 집을 좌표 class를 만들어 관리
->  알고리즘을 하다보니 class를 만들어 관리하는것이 가독성과 관리에 더 편해짐.
arrayList를 통해 집과 치킨집의 class를 관리.
-> 집을 기준으로 치킨집이 가장 가까운 거리를 탐색 및 더함.
-> 더한 결과의 최솟값을 출력
조합을 통해 치킨집을 선택.
-> 순서와 관계없이 조합을 생성.
조합 method가 기저조건에 도달할 때, 조합으로 만든 index배열로 치킨 거리의 최솟값을 구함.
-> 치킨 거리의 최솟값을 구할 때, 하나의 집에서 가장 가까운 치킨집을 탐색.-> 총 2번의 최솟값을 탐색.
 
 */

import java.util.*;
import java.io.*;

public class Main_15686 {
	// 좌표 class
	static class point {
		int row, col;

		public point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	static int N, M, total; // 크기, 치킨집 갯수, 결과값
	static int[][] map; // 입력받는 map
	static List<point> listHouse; // 집 리스트
	static List<point> listChicken; // 치킨집 리스트
	static point[] combiArr; // 조합을 저장할 배열
	static int[] arr; // 조합 index 배열

	// 거리
	public static int dis(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	// 조합
	private static void combination(int[] arr, int n, int r, int index, int target) {
		if (r == 0) {
			combiArr = new point[M]; // 조합을 통해 치킨집 좌표들을 저장하기 위한 배열
			for (int i = 0; i < M; i++) {
				combiArr[i] = listChicken.get(arr[i]); // index를 통해 선택된 치킨집 좌표를 담는다.
			}
			search(combiArr); // 최소 거리 함수.
			return;
		}
		if (target == n) // 조합이 완성되지 못한 경우
			return;

		arr[index] = target; // index 넣기
		combination(arr, n, r - 1, index + 1, target + 1);// 뽑는경우
		combination(arr, n, r, index, target + 1);// 안뽑는경우
	}

	// 치킨집 최소 거리 찾기
	private static void search(point[] combi) {
		int ret = 0;

		for (point i : listHouse) { // 집의 갯수만큼 반복
			int disMin = Integer.MAX_VALUE; // 최소값 초기화
			for (point j : combi) { // 완성된 조합만큼 반복
				int retDis = dis(i.row, i.col, j.row, j.col); // 거리 구하는 method
				disMin = Math.min(disMin, retDis); // 집과 가장 가까운 치킨집 탐색.
			}
			ret += disMin; // 각 집마다 가장 가까운 치킨집 거리의 합
		}
		total = Math.min(total, ret); // 최종 거리 비교
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		total = Integer.MAX_VALUE;

		listHouse = new ArrayList<point>(); // 치킨집
		listChicken = new ArrayList<point>(); // 치킨집

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { // 집
					listHouse.add(new point(i, j));
				} else if (map[i][j] == 2) { // 치킨집
					listChicken.add(new point(i, j));
				}
			}
		} // end of input

		arr = new int[M]; // index를 담을 배열
		combination(arr, listChicken.size(), M, 0, 0); // 조합 만드는 함수 (조합을 만들경우 거리 찾기)
		sb.append(total + "\n");
		System.out.println(sb); // 출력
		br.close();

	}// end of main
}