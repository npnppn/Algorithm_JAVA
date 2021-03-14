package ssafy_algo;
import java.io.*;
import java.util.*;
/*
시뮬레이션으로 아무리 생각해봐도 풀 수가 없었다..
1. 단순하게 생각하면 가로로 왔다갔다, 세로로 왔다갔다.
2. 나는 0,0 에서 시작하는걸로 생각하고 t 와 x 그리고 t 와 y 를 하나로 합쳐서 생각했다.
3.(t + x) / w / 2 의 나머지가 1이면 w 에 도착한거니까 w - (t +x) % w 반대로 생각하는 경우다.
4. y 도 마찬가지
*/

public class Main_10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1[] = br.readLine().split(" ");
		String str2[] = br.readLine().split(" ");
		
		int w = Integer.parseInt(str1[0]);
		int h = Integer.parseInt(str1[1]);
		int x = Integer.parseInt(str2[0]);
		int y = Integer.parseInt(str2[1]);
		int N = Integer.parseInt(br.readLine());
		boolean maxW = (x + N) / w % 2 == 1;
		boolean maxH = (y + N) / h % 2 == 1;
		int resultX = 0;
		int resultY = 0;
		if (maxW) { //w에 도착한 경우니까!
			resultX = w - (x + N) % w;
		} else {
			resultX = (x + N) % w;
		}
		if (maxH) { //h에 도착한 경우니까!
			resultY = h - (y + N) % h;
		} else {
			resultY = (y + N) % h;
		}
		System.out.println(resultX + " " + resultY);

	}

}
