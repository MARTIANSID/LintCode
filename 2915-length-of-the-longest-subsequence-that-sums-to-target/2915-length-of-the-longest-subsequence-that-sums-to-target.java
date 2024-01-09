class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        
        int n = nums.size();
        
      int[] dp = new int[Math.max(target+1,n+1)];
        
        for(int i=0;i<n;i++){
            int[] temp=new int[Math.max(target+1,n+1)];
            for(int j=0;j<=target;j++){
                int sum = j;
                int valReq = sum - nums.get(i);
        
                if(valReq >=0 && dp[valReq] > 0){
                    int len = dp[valReq];
                    temp[sum]=Math.max(dp[valReq],len+1);
                } 
            }
            
            for(int j=0;j<=target;j++){
                dp[j]=Math.max(temp[j],dp[j]);
            }
            
            if(nums.get(i)<=target)
            dp[nums.get(i)] = Math.max(dp[nums.get(i)],1);
            
        }
        
        return dp[target] > 0 ? dp[target] : -1;
    }
}

