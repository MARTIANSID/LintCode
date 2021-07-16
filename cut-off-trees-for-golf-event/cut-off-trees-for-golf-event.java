class Solution {
    
      static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int cutOffTree(List<List<Integer>> forest) {
        
        
        int n=forest.size();
        int m=forest.get(0).size();
            PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
                int r1=a/m,c1=a%m;
                int r2=b/m,c2=b%m;
                
                return forest.get(r1).get(c1)-forest.get(r2).get(c2);
            });
        
        
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
                if(forest.get(i).get(j)>1){
                    pq.add(i*m+j);
                }
          }
      }
        
        int startr=0;
        int step=0;
            while(pq.size()!=0){
                int end=pq.poll();
                int x=bfs(startr,end,forest);
                // System.out.println(x);
                if(x==-1)return -1;
                step+=x;
                startr=end;
            }        
        return step;
        
    }
    
    public int bfs(int point,int end,List<List<Integer>> forest){
        
        LinkedList<Integer> que=new LinkedList<>();
        int m=forest.get(0).size();
        int n=forest.size();
        boolean[][] visited=new boolean[n][m];
        
        int level=0;
        
        int k=point/m;
        int o=point%m;
        visited[k][o]=true;
        que.add(point);
        
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                int poi=que.removeFirst();
                if(poi==end)return level;
                int r=poi/m;
                int c=poi%m;
                for(int i=0;i<dir.length;i++){
                    int row=r+dir[i][0];
                    int col=c+dir[i][1];
                    
                    if(row>=0&&col>=0&&row<n&&col<m&&forest.get(row).get(col)!=0&&visited[row][col]!=true){
                        que.add(row*m+col);
                        visited[row][col]=true;
                    }
                    
                }
                
            }
            level++;
        }
        
        return -1;
    }
}