class Solution {
    Integer[][] dp=new Integer[201][201];
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n=nums.length;
        
        return solve(0,n-1,n,nums,k+1);
        
    }
    
    public int solve(int si,int ei,int n,int[] nums,int k){
            
        if(si>=ei)return 0;
        
        if(k==1){
            int s=0,max=0;
            for(int i=si;i<=ei;i++){
                s+=nums[i];
                max=Math.max(max,nums[i]);
            }
            
            return dp[si][k]= (ei-si+1)*max-s;
        }
        
        if(dp[si][k]!=null)return dp[si][k];
        
        
        int max=-(int)1e9,sum=0,wasted=0,min=(int)1e9;
        for(int i=si;i<=ei;i++){
            max=Math.max(max,nums[i]);
            sum+=nums[i];
            wasted=(i-si+1)*max-sum;
            min=Math.min(min,solve(i+1,n-1,n,nums,k-1)+wasted);
        }
        return dp[si][k]= min;
    }
}