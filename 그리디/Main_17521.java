import java.io.*;
import java.util.*;

public class Main_17521 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long coin = 0;
		int[] chart = new int[n];
		
		for(int i=0; i<n; i++) {
			chart[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<n-1; i++) {
			if(chart[i] < chart[i+1]) {//다음날 올랐어
				if(w>=chart[i]) {
					coin += w/chart[i];
					w %= chart[i];
				}
			}else if(chart[i]> chart[i+1]) {//떨어짐
				w += coin * chart[i];
				coin = 0;
			}
		}
		w += coin * chart[n-1];
		System.out.println(w);	
	}
}
