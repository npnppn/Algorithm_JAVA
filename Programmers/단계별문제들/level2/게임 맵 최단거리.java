import java.io.*;
import java.util.*;
//bfs로 최단거리 탐색하고 갯수 출력!
class Solution {
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int n, m, answer;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    static class Point{
        int x, y, cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] maps) {
        answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        bfs(maps);
        
        if (answer == 0) answer = -1;
        return answer;
    }
    
    static void bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        Point point = new Point(0, 0, 0);
        q.add(point);
    
        while(!q.isEmpty()) {
            Point tmp = q.poll();
            visited[tmp.x][tmp.y] = true;
            if(tmp.x == n-1 && tmp.y == m-1) {
                answer = Math.min(min, tmp.cnt+1);
                return;
            }
            
            for (int k = 0; k<4; k++) {
                int nx = tmp.x + dx[k];
                int ny = tmp.y + dy[k];
                
                if(nx>=0 && ny >=0 && nx<n && ny<m && !visited[nx][ny]
                   && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, tmp.cnt+1));
                    
                }
            }
            
            
        }
        
    }
}
