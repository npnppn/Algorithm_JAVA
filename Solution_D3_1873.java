package ssafy_algo;

import java.util.*;
import java.io.*;

public class Solution_D3_1873 {
	static int T, H, W, x, y, d;
	static char[][] map;
	static int[][] dir = {
			{ 0, 0 }, // 원위치
			{ 0, 1 }, // 우
			{ 0, -1 }, // 좌
			{ 1, 0 }, // 하
			{ -1, 0 } // 상
	};

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input_Solution_D3_1873.txt"));
		Scanner s = new Scanner(System.in);
		T = s.nextInt(); // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			H = s.nextInt(); // 게임 맵의 높이
			W = s.nextInt(); // 게임 맵의 너비
			map = new char[H][W];

			x = 0;
			y = 0;
			d = 0;

			for(int i=0; i<H; i++) {
				String str = s.next();
				for (int j=0; j<W; j++) {
					map[i][j] = str.charAt(j); //게임 구성요소를 맵에 배치
					
					//방향문자가 나올때
					if(map[i][j] == '>' || map[i][j] == '<' || map[i][j] == 'v' || map[i][j] == '^') {
						if(map[i][j] == '>') d = 1; //동
						else if(map[i][j] == '<') d=2; //서
						else if(map[i][j] == 'v') d=3; //남
						else if(map[i][j] == '^') d=4; //북
						
						x=i;
						y=j;
					}		
				}
			}
			
			int N = s.nextInt(); //두번째 문자열 갯수 주어짐
			String str2 = s.next(); //UDLRS 쭉 나열됨
			for(int i=0; i<N; i++) {
				char ch = str2.charAt(i);
				
				//shoot를 제외한 문자동작(동서남북)의 경우를 각각 계산
				if(ch == 'R' || ch == 'L' || ch == 'D' || ch == 'U') {
					if(ch == 'R') { //동
						d=1;
						map[x][y] = '>';
					}
					else if(ch == 'L') { //서
						d=2;
						map[x][y] = '<';
					}
					else if(ch == 'D') { //남
						d=3;
						map[x][y] = 'v';
					}
					else if(ch == 'U') { //북
						d=4;
						map[x][y] = '^';
					}
					int nx = x + dir[d][0];
					int ny = y + dir[d][1];
					
					//내부에 있을 조건 계산
					if (nx>= 0 && nx<H && ny>=0 && ny<W) {
						if(map[nx][ny] == '.') {
							map[nx][ny] = map[x][y];
							map[x][y] = '.'; //평지로 변함
							x = nx;
							y = ny;
						}
					}	
				}
				
				//슈팅일때 계산
				else if(ch == 'S') {
					int nx = x;
					int ny = y;
					
					while(true) {
						nx += dir[d][0];
						ny += dir[d][1];
						//맵 밖으로 나가고, 강철로 만들어진 벽 만나면 아무일 x
						if(!(nx>= 0 && nx<H && ny>=0 && ny<W) || map[nx][ny] =='#')
							break;
						
						//벽돌로 만들어진 벽 만나면
						else if (map[nx][ny] == '*') {
							map[nx][ny] = '.'; //평지로 바꾸고 종료
							break;
						}
					}
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<H; i++) {
				for (int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

}
