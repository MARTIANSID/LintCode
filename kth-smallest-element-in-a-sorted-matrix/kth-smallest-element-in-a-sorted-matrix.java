class Solution {
        
        class pair{
                int row;
                int col;
                int val;
                pair(int row,int col,int val){
                        this.row=row;
                        this.col=col;
                        this.val=val;
                }
        }
    public int kthSmallest(int[][] matrix, int k) {
        
            PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
                    return a.val-b.val;
            });
            
            
            for(int i=0;i<matrix.length;i++){
                    pq.add(new pair(i,0,matrix[i][0]));
            }
            
                int ans=0;            
             while(k-->0){
                   pair p=  pq.poll();
                     ans=p.val;
                     
                    if(p.col+1<matrix[0].length){
                            pq.add(new pair(p.row,p.col+1,matrix[p.row][p.col+1]));
                    }
             }
            return ans;
            
            
            
    }
}