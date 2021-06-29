class Solution {
    public int splitArray(int[] nums, int m) {
        
            int[][] dp=new int[nums.length+1][m+1];
         for(int[] row:dp)Arrays.fill(row,-1);
            return solve(nums,m,0,dp);
            
    }
       public int solve(int[] nums,int m,int si,int[][] dp){
              
               
               
               if(si==nums.length)return dp[si][m]=(int)1e9;
               
               
               
               
               if(dp[si][m]!=-1)return dp[si][m];
               
               if(m==1){
                       int s=0;
                       for(int i=si;i<nums.length;i++){
                               s+=nums[i];
                       }
                       
                       return  dp[si][m]=s;
               }
               
               
               int sum=0;
               int max=(int)1e9;
               for(int i=si;i<nums.length;i++){
                       sum+=nums[i];
                   int x=    solve(nums,m-1,i+1,dp);
                    max=Math.min(max,Math.max(x,sum));
                       
               }
               return dp[si][m]= max;
       } 
}