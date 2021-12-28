package class2;

import java.io.*;
import java.util.*;

// math.pow를 쓰니 오버플로우 발생. 매번 계산때마다 m값으로 나머지를 구하면서 크기를 줄여줘야 해결완료
public class Main_15829 {

	static int r = 31;
	static int m = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long ans = 0;
		long pow = 1;
		for (int i = 0; i < n; i++) {
			ans += ((s.charAt(i) - '0' - 48) * pow) % m;
			pow = (pow *= r) % m;
		}
		System.out.println(ans % m);

	}

}
