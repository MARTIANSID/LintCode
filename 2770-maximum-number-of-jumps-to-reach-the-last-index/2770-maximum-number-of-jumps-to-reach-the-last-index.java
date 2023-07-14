class Solution{
    Integer[] dp;
public int maximumJumps(int[] nums, int target) {
        
        int n=nums.length;
        
        int result=-(int)1e9;
    
        dp=new Integer[n];
        
        
            
        result=solve(0,nums,target);
            
        
   
        return result <0 ? -1 : result;
    }
    
    private int solve(int idx,int[] nums,int target){
        
        if(idx==nums.length-1){
            return 0;
        }
        
        if(dp[idx]!=null)return dp[idx];
        
        int n=nums.length;
        int result=-(int)1e9;
        
        for(int i=idx+1;i<n;i++){
            if(Math.abs(nums[i]-nums[idx])<=target){
                result=Math.max(result,solve(i,nums,target)+1);
            }
        }
        
        return dp[idx]= result;
        
    }
    
}