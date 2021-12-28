package class2;

import java.io.*;
import java.util.*;

//(x.y)에서(0.0)과 (w.h) 거리중 최솟값을 구하면 되겠네
public class Main_1085 {
	static int x, y, w, h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		int min = 0;
		min = Math.min(x - 0, Math.min(y - 0, Math.min(w - x, h - y)));
		System.out.println(min);
	}

}
