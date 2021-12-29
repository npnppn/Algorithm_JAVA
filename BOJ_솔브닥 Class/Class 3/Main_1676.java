package class3;

import java.io.*;
import java.util.*;

//방법이 생각이 안나서 다른 사람의 풀이를 보았다..
//뒷자리가 0인것은 2와5가 곱해질때! 그니까 5로 나누면서 누적합을 구해주면된다.
public class Main_1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;

		while (n >= 5) {
			cnt += n / 5;
			n /= 5;
		}
		System.out.println(cnt);

	}

}
