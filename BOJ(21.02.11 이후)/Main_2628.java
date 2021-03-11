package ssafy_algo;

import java.io.*;
import java.util.*;

public class Main_2628 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); //가로
		int y = sc.nextInt(); //세로
		int n = sc.nextInt(); //점선의 갯수
		int answer = 0;
		ArrayList<Integer> col = new ArrayList<Integer>(); //가로로 자를 것들
		ArrayList<Integer> row = new ArrayList<Integer>(); //세로로 자를 것들
		col.add(0);
		col.add(x);
		row.add(0);
		row.add(y);
		for (int i = 0; i < n; i++) {
			int dir = sc.nextInt();
			int num = sc.nextInt();
			
			if(dir == 0) //첫번째 입력값이 0이면 가로로 자르는거니까 슥삭
				row.add(num);
			else //1이면 세로로 자르는거니까 슥삭 
				col.add(num);
		}
		
		Collections.sort(col);
		Collections.sort(row);
		
		System.out.println(col);
		System.out.println(row);
		
		for (int i = 1; i < col.size(); i++) {
			for (int j = 1; j < row.size(); j++) {
				int size = (col.get(i)-col.get(i-1)) * (row.get(j) - row.get(j-1));
				answer = Math.max(answer, size);
			}
		}
		System.out.println(answer);
	}
}