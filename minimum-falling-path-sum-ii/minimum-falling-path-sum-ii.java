class Solution {
    class pair{
        int col;
        int val;
        pair(int col,int val){
            this.col=col;
            this.val=val;
        }
    }
    
    Integer[][]  dp;
    
    public int minFallingPathSum(int[][] grid) {
        dp=new Integer[grid.length+1][grid[0].length+1];
        List<List<pair>> mins=new ArrayList<>();
         
        for(int i=0;i<grid.length;i++){
           
            int min1=(int)1e9,min2=(int)1e9,c1=0,c2=0;
            List<pair> arr=new ArrayList<>(); 
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]<=min1){
                    
                    min2=min1;
                    c2=c1;
                    min1=grid[i][j];
                    c1=j;
                }else if(grid[i][j]<min2){
                    min2=grid[i][j];
                    c2=j;
                }
            }
            arr.add(new pair(c1,min1));
            arr.add(new pair(c2,min2));
            mins.add(arr);
        }
        
        int min=(int)1e9;
       for(int i=0;i<2;i++){
           int col=mins.get(0).get(i).col;
           min=Math.min(min,solve(mins,1,col)+mins.get(0).get(i).val);
       }
        return min;
    }
    
    public int solve(List<List<pair>> mins,int r,int c){
        if(r==mins.size())return 0;
        
        if(dp[r][c]!=null)return dp[r][c];
        
        int min=(int)1e9;        
            for(int i=0;i<2;i++){
               int col= mins.get(r).get(i).col;
                if(c!=col){
                   min=Math.min(min, solve(mins,r+1,col)+mins.get(r).get(i).val);
                }
            }
        return  dp[r][c]= min;
    }
}