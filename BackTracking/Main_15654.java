package permu_combi2;
//스스로 풀어봤음!
//항상 뭘 선택하고 뭘 방문체크할건지 잘 생각하자!
import java.io.*;
import java.util.*;


public class Main_15654 {
	static int n, m;
	static int[] arr;
	static int[] selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		visited = new boolean[n+1];
		selected = new int[m];

		permu(0, selected, visited);
		System.out.print(sb);
	}

	static void permu(int toselect, int[] selected, boolean[] visited) {
		if (toselect == m) {
			for (int i : selected) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[toselect] = arr[i-1];
				permu(toselect + 1, selected, visited);
				visited[i] = false;
			}
		}
	}
}
