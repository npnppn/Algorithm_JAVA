package greedy;

import java.io.*;
import java.util.*;

//마지막에 break로 끊어주지않으니 시간초과가 계속난다
public class Main_2457 {

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Point> arr = new ArrayList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int b1 = Integer.parseInt(st.nextToken());
			int b2 = Integer.parseInt(st.nextToken());
			arr.add(new Point(a1 * 100 + a2, b1 * 100 + b2));
		}

		Collections.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x == o2.x)
					return o1.y - o2.y;
				return o1.x - o2.x;
			}
		});

		int last = 301;
		int idx = 0;
		int cnt = 0;
		int max = Integer.MIN_VALUE;
		while (last < 1201) {
			boolean check = false;

			for (int i = idx; i < N; i++) {
				if (arr.get(i).x > last)
					break;

				// x값이 max값보다 작은 것들 중 y의 값이 가장 큰것을 선택
				if (arr.get(i).x <= last && max < arr.get(i).y) {
					max = arr.get(i).y;
					idx = i + 1;
					check = true;
				}
			}

			if (check) {
				last = max;
				cnt++;
			} else
				break;
		}
		
		//만족하는 꽃 없을땐 0
		if (max < 1201)
			System.out.println(0);
		else
			System.out.println(cnt);

	}
}