class Solution {
    Integer[][] dp;
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        
        dp=new Integer[n1][(int)Math.pow(2,n2)+1];
        
        
        return solve(nums1,nums2,0,0);
        
        
    }
    
    public int solve(int[] nums1,int[] nums2,int mask,int index){
        
        
        if(index == nums1.length)return 0;
        
        if(dp[index][mask]!=null)return dp[index][mask];
        
        int min=(int)1e9;
        for(int i=0;i<nums2.length;i++){
            if((mask&(1<<i))==0)
            min=Math.min(min,(nums1[index]^nums2[i])+solve(nums1,nums2,(mask|(1<<i)),index+1));
        }
        return dp[index][mask]= min;
    }
}