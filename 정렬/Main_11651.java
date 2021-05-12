package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11651 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		// y좌표 증가순으로, 만약 y좌표 같으면 x좌표 증가순으로
		Arrays.sort(arr, (o1, o2) -> {
			if (o2[1] == o1[1])
				return o1[0] - o2[0];
			else {
				return o1[1] - o2[1];
			}

		});

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

	}

}
