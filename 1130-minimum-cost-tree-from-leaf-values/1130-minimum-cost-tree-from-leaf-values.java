class Solution {
    
    //0->max value
    //1->min sum
    
    int[][][] dp;
    
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        dp=new int[n][n][];
        return solve(arr,0,n-1)[1];
        
    }
    public int[] solve(int[] arr,int si,int ei){
        
        
        if(si == ei){
    
            return new int[]{arr[si],0};
        }
        
        if(dp[si][ei]!=null)return dp[si][ei];
        
        int min=(int)1e9,max=0;
    
        for(int i=si;i<=ei-1;i++){
            int[] left=solve(arr,si,i);
            int[] right=solve(arr,i+1,ei);
            int leftMax=left[0],rightMax=right[0];
            max=Math.max(max,Math.max(leftMax,rightMax));
            min=Math.min(min,leftMax*rightMax+left[1]+right[1]);
        }
        return dp[si][ei]= new int[]{max,min};
    }
}