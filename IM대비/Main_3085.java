import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int N;
	public static char[][] map;
	public static char[][] switchedMap;
	public static int maxCount;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		switchedMap = new char[N][N];
		
		for(int row = 0 ; row<N; row++) {
			String line = br.readLine().trim();
			for(int column = 0; column<N; column++) {
				map[row][column] = line.charAt(column);	
			}
		}
		
		selectCandy();
		
		bw.write(String.valueOf(maxCount));
		bw.flush();
		
		
		
	}
	
	public static void selectCandy() {
		for(int r= 0 ;r<N; r++) {
			for(int c=0; c<N; c++) {
				char pickCandy1 = map[r][c];
				char pickCandy2 = ' ';
				
				if(c+1<N) {
					pickCandy2 = map[r][c+1];
					if(pickCandy1 != pickCandy2) {
						//색깔다른 인접한 사탕 자리 바꾸기
						copyMap();
						switchedMap[r][c] = pickCandy2;
						switchedMap[r][c+1] = pickCandy1;
						
						calculateMax();
					}
				}
				if(r+1<N) {
					pickCandy2 = map[r+1][c];
					if(pickCandy1 != pickCandy2) {
						//색깔다른 인접한 사탕 자리 바꾸기
						copyMap();
						switchedMap[r][c] = pickCandy2;
						switchedMap[r+1][c] = pickCandy1;
						
						calculateMax();
					}
				}
			}
		}
	}
	
	public static void calculateMax() {
		for(int r = 0 ; r<N; r++) {
			int count = 1;
			for(int c= 1; c<N; c++) {
				if(switchedMap[r][c] == switchedMap[r][c-1]) {
					++count;
					maxCount = Math.max(maxCount, count);
				}
				else {
					count =1;
				}
			}
		}
		
		for(int c=0; c<N; c++) {
			int count = 1;
			for(int r=1; r<N; r++) {
				if(switchedMap[r][c] == switchedMap[r-1][c]) {
					++count;
					maxCount = Math.max(maxCount, count);
				}
				else {
					count =1;
				}
			}
		}
	}
	
	public static void copyMap() {
		for(int row = 0 ; row<N; row++) {
			for(int column = 0; column<N; column++) {
				switchedMap[row][column] = map[row][column];	
			}
		}
	}
	
	
}
