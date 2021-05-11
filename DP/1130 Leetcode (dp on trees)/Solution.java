class Solution {
    public int mctFromLeafValues(int[] arr) {
            int[][] dp=new int[arr.length][arr.length];
            
            for(int[] row:dp)Arrays.fill(row,-1);
        return solve(arr,0,arr.length-1,dp);
    }
        
        public int solve(int[] arr,int si,int ei,int[][] dp){
                if(si==ei){
                        
                        return  dp[si][ei]=0;
                }
                
        if( dp[si][ei]!=-1) return dp[si][ei];
                 int a=(int)1e9;
                
            for(int i=si;i<ei;i++){
                    
                   int left=solve(arr,si,i,dp);
                   int right=solve(arr,i+1,ei,dp);
                    
                   int leftMax= getMax(arr,si,i);
                   int rightMax=getMax(arr,i+1,ei);
                    
              a=      Math.min(left+right+leftMax*rightMax,a);
                    
                    
                    
            }    
                
                return   dp[si][ei]=a;
                
                
                
                
                
 }
        
        public int getMax(int[] arr,int si,int ei){
                
                int max=0;
                
                for(int i=si;i<=ei;i++){
                        max=Math.max(arr[i],max);
                }
                
                return max;
        }
}