class Solution {
    
    Integer[] dp;
    public boolean canJump(int[] nums) {
        
        dp = new Integer[nums.length];
        
        Arrays.fill(dp,-1); // -1 -> dp is not set
        
        return dfs(0,nums);
    }
    
    public boolean dfs(int index,int[] nums){
        
        if(index == nums.length-1) return true;
        
        if(dp[index]!=-1){
            if(dp[index] == 1)return true;
            else return false;
        }
        
        for(int jump=1;jump<=nums[index];jump++){  
            int nextIndex = index + jump; 
            
            if(nextIndex >= nums.length)continue;
            
            boolean result = dfs(nextIndex,nums);
            
            if(result) return true;
        }
        
        dp[index] = 0; // false
        
        return false;
    }
    
}

// index = 0
// nums[index] = 2
    
    


// def recursion(index):
//     for jump in range(1,nums[index]):  (1,2) ()
//         bool ans = recursion(index+jump)  // possibilities explore
//         if ans:
//             return true
//     return false
