import java.io.*;
import java.util.*;

public class Main_2477 {

	// 동1 서2 남3 북4

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());

		int[][] arr = new int[6][2];
		int[] dir = new int[5];
		int maxH = 0;
		int maxW = 0;
		int hidx = 0;
		int widx = 0;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int d = arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

			// 남북으로
			if (d == 3 || d == 4) {
				if (maxH < arr[i][1]) {
					maxH = arr[i][1];
					hidx = i;
				}
			}
			// 동서로
			else {
				if (maxW < arr[i][1]) {
					maxW = arr[i][1];
					widx = i;
				}
			}
			dir[d]++;
		}

		int hp, hw;

		if ((dir[3] == 2 && dir[2] == 2) || (dir[4] == 2 && dir[1] == 2)) {
			hp = (hidx + 2) % 6;
			hw = (widx - 2 + 6) % 6;
		} else {
			hp = (hidx - 2 + 6) % 6;
			hw = (widx + 2) % 6;
		}
		int area = (maxH * maxW) - (arr[hp][1] * arr[hw][1]);
		System.out.println(K * area);
	}
}