package ssafy_algo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D4_1210 {
	public static void main(String[] args) throws FileNotFoundException {
		int dx[] = { 0, 0, -1 }; // 우, 좌, 상
		int dy[] = { 1, -1, 0 };
		int x = 0; // 2가 있는 위치
		int y = 0;
		int ans = 0;
		System.setIn(new FileInputStream("res/input_Solution_D4_1210.txt"));
		Scanner s = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int test = s.nextInt(); //테케 입력받음
			int arr[][] = new int[100][100];
			boolean visited[][] = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = s.nextInt(); // 사다리 입력받음
					if (arr[i][j] == 2) {
						x = i;
						y = j;
					} // 사다리 쭉 찾아보고.. 2가 있는 위치를 x, y로 저장
				}
			}
			
			// 탐색 시작
			boolean flag = false; // 체크포인트
			while (true) {
			    visited[x][y] = true;
			    for (int i = 0; i < 3; i++) {// 우, 좌, 상
			        int nx = x + dx[i];
			        int ny = y + dy[i];
			        if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && arr[nx][ny] != 0 && !visited[nx][ny]){
			            visited[nx][ny] = true;
			            x = nx;
			            y = ny;
			            break;
			        }
			        if(x == 0) { // 맨위로 왔으면 [0][y]에서 y값을 출력하면 정답!
			            ans = y;
			            flag = true;
			            break;
			        }
			    }
			    if(flag) break;
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
