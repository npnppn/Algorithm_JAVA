package permu_combi2;

import java.util.*;
import java.io.*;

//중복되는 경우는 넘어가고, 중복되지 않을때만 리스트에 넣어줌
public class Main_15663 {
	static int n, m;
	static int[] selected;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		selected = new int[m];
		visited = new boolean[n + 1];
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
			
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					
					
				//2번째 원소중 이전에 나온것 또 나오면 안됨	
				int cnt = 0;
				for (int j = 0; j < list.size(); j++) {
					if (arr[i] == list.get(j)) {
						cnt++;
					}
				}

				if (cnt == 0) {
					//중복 x
					visited[i] = true;
					selected[toselect] = arr[i];
					list.add(arr[i]);
					permu(toselect + 1, selected);
					visited[i] = false;
				} else {
					continue;
				}
				

				}
			}

		}

	}
}
