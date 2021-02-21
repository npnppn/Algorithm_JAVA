package permu_combi;

import java.io.*;
import java.util.*;

public class Main_15650 {
	private static int N;
	private static int M;
	private static int[] selected;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		combi(0, selected, 0);
		System.out.print(sb);
	}
	
	public static void combi(int toselect, int[] selected, int startIdx) {
		if (toselect == M) {
			for (int i : selected)
				sb.append(i + " ");
			sb.append("\n");
			return;
		}
		
		for(int i=startIdx; i<N; i++) {
			selected[toselect]=i+1;
			combi(toselect+1, selected, i+1);
		}
		
	}

}
