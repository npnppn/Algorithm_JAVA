package ssafy_algo;
import java.io.*;
import java.util.*;

public class Main_11726 {
	static int N;
	static int[] dx;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dx = new int[1001];
		System.out.println(dp(N));
	}
	
	static int dp(int x) {
		
		if(x==1) return 1;
		if(x==2) return 2;
		if(dx[x] != 0) return dx[x];
		return dx[x] = (dp(x-1) +dp(x-2)) % 10007;
	}

}
