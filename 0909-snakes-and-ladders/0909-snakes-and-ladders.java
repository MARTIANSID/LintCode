class Solution {
   
    public int snakesAndLadders(int[][] board) {
        
            LinkedList<Integer> que=new LinkedList<>();
            
            que.add(1);
            int level=0;
            int n=board[0].length;
            boolean[] visited=new boolean[n*n+1];
            while(que.size()!=0){
                    int size=que.size();
                    
                    while(size-->0){
                            int point=que.removeFirst();
                             // System.out.println(point);
                            int p=getCord(point,n);
                            if(point==n*n){
                                    return level;
                            }
                            
                            if(visited[p]){
                                    continue;
                            }
                            
                            visited[p]=true;
                            
                
                            
                            for(int i=1;i<=6&&point+i<=n*n;i++){
                                  
                                    int newPoint=point+i;
                                     
                                  int y=  getCord(newPoint,n);
                                    int row=y/n;
                                    int col=y%n;

                                    if(board[row][col]==-1){
                                            que.add(newPoint);
                                    }else{
                                            que.add(board[row][col]);
                                    }
                                    
                                    
                            }
                            
                            
                            
                    }
                  
                    level++;
                    
            }
            
            return -1;
            
            
    }
        
//         public int getCord(int point,int n){
                
//                 int row=(n*n-point)/n;

//                 int col=row%2==0?(n-(point-1)%n-1):(point-1)%n;
        
               
//                 return row*n+col;
//         }
        public int getCord(int s, int N) {
        // Given a square num s, return board coordinates (r, c) as r*N + c
        int quot = (s-1) / N;
        int rem = (s-1) % N;
        int row = N - 1 - quot;
        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
        return row * N + col;
    }
        
        // row = (N*N-point)/N
        // col=row%2==0?(point-1)%N:N-(point-1)%N-1
}