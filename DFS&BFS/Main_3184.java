import java.util.*;
 
public class Main {
    static int r,c;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        arr = new int[r][c];
        for(int i=0;i<r;i++) {
            String t = sc.next();
            for(int j=0;j<c;j++)
                arr[i][j] = t.charAt(j);
        }
        // 방문 표시
        visited = new boolean[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                // 돌아다닐 수 있는 공간이 있으면 돌아다니자.
                if(arr[i][j]!='#'&&!visited[i][j])
                    solve(i,j);
            }
        }
        System.out.println(tSheep+" "+tWolf);
    }
    
    static int tWolf,tSheep;
    static boolean[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void solve(int x,int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));
        visited[x][y] = true;
        int wolf = 0,sheep = 0;
        // 시작 위치가 늑대나 양일 경우
        if(arr[x][y]=='v') wolf++;
        else if(arr[x][y]=='o') sheep++;
        while(!queue.isEmpty()) {
            Pair t = queue.poll();
            
            for(int i=0;i<4;i++) {
                int tx = t.x+dir[i][0];
                int ty = t.y+dir[i][1];
                if(tx<0 || ty<0 || tx>=r || ty>=c) continue;
                if(visited[tx][ty]) continue;
                visited[tx][ty] = true;
                if(arr[tx][ty]=='#') continue;
                // 그 울타리 안의 늑대와 양 카운트
                if(arr[tx][ty]=='v') wolf++;
                else if(arr[tx][ty]=='o') sheep++;
                queue.add(new Pair(tx,ty));
            }
        }
        // 울타리 안의 늑대와 양 수에따른 결과 계산
        if(wolf>=sheep) tWolf+=wolf;
        else tSheep+=sheep;
    }
    
    static class Pair{
        private int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
