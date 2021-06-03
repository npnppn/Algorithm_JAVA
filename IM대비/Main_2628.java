import java.io.*;
import java.util.*;

public class Main_2628 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); // 맵 가로
		int y = sc.nextInt(); // 맵 세로

		ArrayList<Integer> width = new ArrayList<Integer>();
		ArrayList<Integer> height = new ArrayList<Integer>();

		int n = sc.nextInt(); // 잘라야하는 점선 갯수
		for (int i = 0; i < n; i++) {
			int how = sc.nextInt(); // 0이면 가로로 잘라, 1이면 세로로 잘라
			int value = sc.nextInt();

			// 가로면
			if (how == 0) {
				height.add(value);
			}

			// 세로면
			else {
				width.add(value);
			}

		}

		// 자른것중에 제일 큰거를 구해보자
		Collections.sort(height);
		Collections.sort(width);

		//System.out.println(height);
		//System.out.println(width);
		//System.out.println(height.get(height.size()-1));
		
		int w = 0;
		int start = 0;
		for (int i = 0; i < width.size(); i++) {
			if (width.get(i) - start > w) {
				w = width.get(i) - start;
			}
			start = width.get(i);
		}
		if (x - start > w) {
			w = x - start;
		}
		
		
		int h = 0;
		start = 0;
		for (int i = 0; i < height.size(); i++) {
			if (height.get(i) - start > h) {
				h = height.get(i) - start;
			}
			start = height.get(i);
		}
		if (y - start > h) {
			h = y - start;
		}
		System.out.println(h * w);
	}

}