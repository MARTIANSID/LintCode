class Solution {
    static int[][] dir=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        LinkedList<Integer> que=new LinkedList<>();
        int n=maze.length;
        int m=maze[0].length;
        
        que.add(entrance[0]*m+entrance[1]);
        
        boolean[][] visited=new boolean[n][m];
        
        int level=0;
        visited[entrance[0]][entrance[1]]=true;
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
              int point=  que.removeFirst();
            int r=point/m;
            int c=point%m;
                if(r!=entrance[0]||c!=entrance[1]){
                      if(r==0||r==n-1||c==0||c==m-1)return level;
                }
            for(int i=0;i<4;i++){
                int row=r+dir[i][0];
                int col=c+dir[i][1];
                if(row>=0&&col>=0&&row<n&&col<m&&maze[row][col]!='+'&&visited[row][col]==false){
                    visited[row][col]=true;
                    que.add(row*m+col);
                }
            }
        
            }
             level++;
        }
        return -1;
       
    }
}