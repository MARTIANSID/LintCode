class Solution {
        int max=0;
    public int findLength(int[] nums1, int[] nums2) {
            int[][] dp=new int[nums1.length+1][nums2.length+1];
            for(int[] row:dp)Arrays.fill(row,-1);
          int y= solve(nums1,nums2,0,0,dp);
            
            return max;
    }
        public int solve(int[] nums1,int[] nums2,int i,int j,int[][] dp){
                
                if(i==nums1.length||j==nums2.length)return dp[i][j]= 0;
                
                if(dp[i][j]!=-1)return dp[i][j];
                
                if(nums1[i]==nums2[j]){
                      int x=   solve(nums1,nums2,i+1,j+1,dp)+1;
                    max=Math.max(max,x);
                          solve(nums1,nums2,i+1,j,dp);
                                solve(nums1,nums2,i,j+1,dp);
                        return dp[i][j]= x;
                }else{
                               solve(nums1,nums2,i+1,j,dp);
                                solve(nums1,nums2,i,j+1,dp);
                        return dp[i][j]=0;

                        
                }
        
        }
}