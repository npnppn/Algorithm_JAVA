package etc;

import java.io.*;
import java.util.*;

public class Main_24040 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			int num = Integer.parseInt(br.readLine());

			// 빨초하양이 순서대로 나와야함
			// 3k+2꼴이거나 9의 배수면 예쁜 케이크
			if (num % 3 == 2 || num % 9 == 0) {
				System.out.println("TAK");
			} else {
				System.out.println("NIE");
			}
		}
	}

}
