class Solution {
public:
    
    vector< int >dp = vector< int >(105, -1);
    
    int robUtil(vector<int>& nums, int ind, int n) {
        
        if(ind >= n)
            return 0;
        
        if(dp[ind] != -1)
            return dp[ind];
        
        return dp[ind] = max(nums[ind] + robUtil(nums, ind + 2, n), robUtil(nums, ind + 1, n));
    }
    
    int rob(vector<int>& nums) {
        
        int n = nums.size();
        
        int val1 = robUtil(nums, 1, n);
        
        fill(dp.begin(), dp.end(), -1);
        
        int val2 = nums[0] + robUtil(nums, 2, n - 1);
        
        return max(val1, val2);
    }
};