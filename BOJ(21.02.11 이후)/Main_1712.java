package ssafy_algo;
import java.io.*;
import java.util.*;

public class Main_1712 {
	public static void main(String[] args) throws IOException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		long x = 0;
		if (b>=c) {
			x = -1;
		}
		else {
			x = (a / (c-b) +1);
		}
		System.out.println(x);
	
	}

}
