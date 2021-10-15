class Solution {
    Integer[][] dp;
    public int stoneGameV(int[] stoneValue) {
     
        int n=stoneValue.length,sum=0;
        dp=new Integer[n+1][n+1];
        int[] prefixSum=new int[n];
        for(int i=0;i<n;i++){
            sum+=stoneValue[i];
            prefixSum[i]=sum;
        }
        
        return solve(stoneValue,0,n-1,n,prefixSum);
        
    }
    public int solve(int[] stoneValue,int si,int ei,int n,int[] prefixSum){
        if(si==ei)return 0;
        
        if(dp[si][ei]!=null)return dp[si][ei];
        
        int max=-(int)1e9;
       for(int cut=si;cut<ei;cut++){
             //left array cut+1 to ei (both index included)
            //rigth array si to cut   (both index included)
           
           int leftSum=0,rightSum=0;
           //calculating sum of left array
           if(si-1<0)leftSum=prefixSum[cut];
           else leftSum=prefixSum[cut]-prefixSum[si-1];
           
           
           //calculating sum of right array
          rightSum=prefixSum[ei]-prefixSum[cut];
           
           
           if(rightSum>leftSum){
              max=Math.max(max, solve(stoneValue,si,cut,n,prefixSum)+leftSum);
           }else if(leftSum>rightSum){
               max=Math.max(max,solve(stoneValue,cut+1,ei,n,prefixSum)+rightSum);
           }else{
                                max=Math.max(max,Math.max(solve(stoneValue,cut+1,ei,n,prefixSum)+rightSum,solve(stoneValue,si,cut,n,prefixSum)+leftSum));
           }
           
       }
        return dp[si][ei]= max;
    }
}

// [1,2,3,4,5]