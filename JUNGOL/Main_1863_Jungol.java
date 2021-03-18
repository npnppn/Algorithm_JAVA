package ssafy_algo;

//유니온파인드를 활용한 정올문제
//주말에 좀 더 천천히 공부해봐야할듯?
import java.util.Scanner;

public class Main_1863_Jungol {
	private static int[] parents; // 집합을 나타낼 배열

	public static void main(String[] args) {
		Main_1863_Jungol reli = new Main_1863_Jungol();
		reli.disjoint();
	}

	/** 서로소 집합을 이용해보자 */
	private void disjoint() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		make(n); // 서로소 만들기
		int result = 0;

		for (int i = 0; i < m; i++) {
			int first = sc.nextInt();
			int sec = sc.nextInt();

			union(first, sec); // 합집합 만들기
		}

		result = amount_religion();
		System.out.println(result);

		sc.close();
	}

	/** 종교의 개수를 리턴해주자 */
	private int amount_religion() {
		int amount = 0;
		for (int i = 1; i < parents.length; i++) {
			if (parents[i] == i)
				amount++; // 자신의 집합이 대표자인 경우만 출력
		}
		return amount;
	}

	/** 합집합 만들기 */
	private void union(int first, int sec) {
		int aroot = find(first); // 자신이 속한 집합을 구한다.
		int broot = find(sec);

		if (aroot != broot) { // 서로 다른 집합이라면
			parents[broot] = aroot; // 하나로 합쳐준다
		}
	}

	/** 조상 노드 찾기 */
	private int find(int num) {
		if (parents[num] == num)
			return num;
		return parents[num] = find(parents[num]);
	}

	/** 초기 서로소 집합 */
	private void make(int n) {
		parents = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
}