class Solution {
    Integer[][] dp1;
    
    Integer[][] dp2;
    
    public int numTeams(int[] rating) {
        
        int ans=0;
        
        int n=rating.length;
        
        dp1=new Integer[n+1][4];
        dp2=new Integer[n+1][4];

        
        for(int i=0;i<rating.length;i++){
            ans+=solve(i,1,rating);
        }
        
        for(int i=0;i<rating.length;i++){
            ans+=solveD(i,1,rating);
        }
        
        return ans;
        
    }
    
    public int solve(int index,int c,int[] arr){
        
        int count=0;
        
        if(c==3)return 1;
        
        if(dp1[index][c]!=null)return dp1[index][c];
        
        for(int i=index+1;i<arr.length;i++){
            if(arr[i]>arr[index]){
                count+=solve(i,c+1,arr);
            }
        }
        return dp1[index][c]= count;
        
    }
    
     public int solveD(int index,int c,int[] arr){
        
        int count=0;
        
        if(c==3)return 1;
         
          if(dp2[index][c]!=null)return dp2[index][c];
        
        for(int i=index+1;i<arr.length;i++){
            if(arr[i]<arr[index]){
                count+=solveD(i,c+1,arr);
            }
        }
        return dp2[index][c]= count;
        
    }
}