class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
            
            int[] dp=new int[pairs.length];
            
            Arrays.fill(dp,-1);
            
            int max=0;
            for(int i=0;i<pairs.length;i++){
                    max=Math.max(solve(pairs,i,dp),max);
            }
            
            return max;
            
        
    }
        
        public int solve(int[][] pairs,int index,int[] dp){
                
                if(dp[index]!=-1)return dp[index];
                
                int a=1;
                for(int i =index+1;i<pairs.length;i++){
                        if(pairs[index][1]<pairs[i][0]){
                                
                             a=Math.max(a,solve(pairs,i,dp)+1);
                                
                        }
                }
                return dp[index]= a;
        }
}