class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length,ans=0;
        
        int[] dp=new int[n];
        
        for(int i=n-1;i>=0;i--){
            int max=0;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}