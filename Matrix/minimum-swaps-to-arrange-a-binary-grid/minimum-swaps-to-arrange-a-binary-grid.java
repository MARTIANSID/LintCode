class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
       LinkedList<Integer> que
            = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            int zeros=0;
            for(int j=m-1;j>=0;j--){
                if(grid[i][j]==0){
                    zeros++;
                }else{
                    break;
                }
            }
            que.add(zeros);
            
        }
        
        
        int swaps=0;
        for(int i=0;i<n;i++){
            int req=n-i-1,index=-1;
            for(int j=i;j<que.size();j++){
                if(que.get(j)>=req){
                    index=j;
                    break;
                }
            }
            
            if(index==-1)return -1;
            int ele=que.get(index);
            que.remove(index);
            que.addFirst(ele);
            swaps+=(index-i);
            
        }
        
        return swaps;
       
    }
}






