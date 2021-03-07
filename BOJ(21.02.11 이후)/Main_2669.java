package ssafy_algo;
import java.io.*;
import java.util.*;

public class Main_2669 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int cnt=0;
		for (int i=0; i<4; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for (int j=x; j<a; j++) {
				for (int k=y; k<b; k++) {
					map[j][k] = 1;
				}
			}
		}
			
			for (int j=0; j<101; j++) {
				for (int k=0; k<101; k++) {
					if (map[j][k] == 1) {
						cnt++;
					}
				}
			}
			
			
		
		System.out.println(cnt);
	}
}

