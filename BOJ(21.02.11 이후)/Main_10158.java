package ssafy_algo;

import java.io.*;
import java.util.*;

/*
시뮬레이션으로 아무리 생각해봐도 풀 수가 없었다..
1. 단순하게 생각하면 가로로 왔다갔다, 세로로 왔다갔다.
x방향 이동만 생각해보면..
그럼 개미는 시간 t동안 0~w까지 왕복 이동한다는 것을 알 수 있다.
p+t는 개미가 t동안 총 이동한 거리를 뜻하는데 여기에 w를 나누면 개미가 0~w까지 몇 번 왕복했는지 알 수 있다.
그렇다면 t이후에 개미의 위치는 어디일까?
이 값은 (p+t)/w가 짝수인가 홀수인가에 따라 다르다.
이 값이 짝수이면 x=0에서 출발해 (p+t)%w인 곳에 개미가 위치하고
이 값이 홀수이면 x=w에서 출발해 -(p+t)%w인 곳에 개미가 위치한다.
y방향 이동도 비슷하게 구하면 된다.
*/
public class Main_10158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		p += t % (w * 2);
		q += t % (h * 2);

		if (p > w)
			p = (w * 2) - p;
		if (q > h)
			q = (h * 2) - q;

		bw.write(Math.abs(p) + " " + Math.abs(q));
		bw.flush();
	}

}
