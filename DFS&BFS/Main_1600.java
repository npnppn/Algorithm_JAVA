package ssafy_algo;
import java.io.*;
import java.util.*;
/* 알게된점
- 말처럼 K 번 이동한 3차원 배열의 visit 에서,   K 3차원 배열에서 비교해야 할지 ( 말처럼 새롭게 뛸 경우 )
   K-1 3차원 배열 ( 이전 배열 기준 ) 에서 비교해야 할지 고민 됐다. 방문처리를 어디서 처리해야할지 혼란
-  K 3차원 배열에서 처리하는게 맞다.
-  왜 ? 문제는 : 최단 거리를 구하는 것이다.
-  내가 가려고 하는 곳에 이미 방문한 적이 있다면 그 녀석이 나보다 빠른 것이다.

2차원으로 했는데 답이 이상하게 나옴.. 어렵넹
*/

public class Main_1600 {
	 static int K;
	    static int W,H;
	    static int[][] map;
	    static boolean[][][] visited;
	    static Queue<Node> q = new LinkedList<>();
	    static int[] dx = {0,0,1,-1,-2,-1,1,2,2,1,-1,-2};
	    static int[] dy = {1,-1,0,0,1,2,2,1,-1,-2,-2,-1};
	    
	    public static void main(String[] args) throws IOException {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        K = Integer.parseInt(br.readLine());
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        W = Integer.parseInt(st.nextToken());
	        H = Integer.parseInt(st.nextToken());
	                
	        map = new int[H][W];
	        visited = new boolean[H][W][K+1];
	        
	        for (int i = 0; i < H; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < W; j++) {
	                map[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
	        
	        visited[0][0][K] = true;
	        q.add(new Node(0, 0, K));
	        int cnt = 0;
	        boolean ok = false;
	        
	        loop :while(!q.isEmpty()) {
	            int size = q.size();
	            
	            for (int s = 0; s < size; s++) {
	                Node cur = q.poll();
	                
	                if(cur.x == H-1 && cur.y == W-1) {
	                    ok = true;
	                    break loop;
	                }
	                
	                for (int i = 0; i < 4; i++) {
	                    int nx = cur.x + dx[i];
	                    int ny = cur.y + dy[i];
	                    
	                    if(!isRange(nx, ny) || visited[nx][ny][cur.horse] || map[nx][ny] == 1)
	                        continue;
	                    
	                    visited[nx][ny][cur.horse] = true;
	                    q.add(new Node(nx, ny, cur.horse));
	                }
	                
	                if(cur.horse > 0) {
	                    for (int i = 4; i < 12; i++) {
	                        int nx = cur.x + dx[i];
	                        int ny = cur.y + dy[i];
	                        
	                        if(!isRange(nx, ny) || visited[nx][ny][cur.horse-1] || map[nx][ny] == 1)
	                            continue;
	                        
	                        visited[nx][ny][cur.horse-1] = true;
	                        q.add(new Node(nx, ny, cur.horse-1));
	                    }    
	                }
	            }
	            cnt++;
	        }
	        System.out.println(ok ? cnt : -1);
	        
	    }
	    
	    static boolean isRange(int x, int y) {
	        if( x < 0 || x >= H || y < 0 || y >= W) return false;
	        return true;
	    }
	}
	 
	class Node {
	    int x;
	    int y;
	    int horse;
	    Node (int x, int y, int horse) {
	        this.x = x;
	        this.y = y;
	        this.horse = horse;
	    }
	}