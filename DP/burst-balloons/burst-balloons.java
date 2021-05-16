class Solution {
    public int maxCoins(int[] nums) {
        
            List<Integer> ballons=new ArrayList<>();
            
            ballons.add(1);
            
            
            for(int ele:nums){
                    ballons.add(ele);
            }
            
            ballons.add(1);
            
            int[][] dp=new int[nums.length+2][nums.length+2];
            for(int[] row:dp)Arrays.fill(row,-1);
            
         return   solve(ballons,1,nums.length,dp);
    }
        public int solve(List<Integer> nums,int si,int ei,int[][] dp){
                
                
                
                if(ei<si){
                        return dp[si][ei]=0 ;
                }
                
                if(dp[si][ei]!=-1)return dp[si][ei];
                
                int max=0;
                
                for(int i=si;i<=ei;i++){
                                                 
                     int left=  solve(nums,si,i-1,dp);
                   int right=     solve(nums,i+1,ei,dp);
                        
                        max=Math.max(max,left+right+nums.get(ei+1)*nums.get(i)*nums.get(si-1));
                       
                        
                }
                return dp[si][ei]=max;
                
                
                
        }
}