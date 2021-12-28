package class2;

import java.io.*;
import java.util.*;

public class Main_2869 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		int snail = a - b; // 하루동안 올라갈 수 있는 높이
		int fall = v - b; // 나무에서 떨어지는 높이
		int day = fall / snail;
		if (fall % snail != 0)
			day++;

		System.out.println(day);

	}

}
