package permu_combi2;

import java.util.*;
import java.io.*;

//이건 자기 자신도 포함하는 퍼뮤테이션이군!
//visited를 그냥 아예 안써도 될거같은데?
public class Main_15656 {
	static int n, m;
	static int[] selected;
	static int[] arr;
	//static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		selected = new int[m];
	//visited = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		permu(0, selected);
		System.out.println(sb);

	}

	static void permu(int toselect, int[] selected) {
		if (toselect == m) {
			for (int i : selected) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= n; i++) {
			//if (!visited[i]) {
			//	visited[i] = true;
				selected[toselect] = arr[i-1];
				permu(toselect + 1, selected);
			//	visited[i] = false;

			//}
		}

	}

}
