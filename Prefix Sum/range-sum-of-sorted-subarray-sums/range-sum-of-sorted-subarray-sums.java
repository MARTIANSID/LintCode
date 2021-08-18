class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int  N=n*(n+1)/2,k=0,mod=(int)1e9+7;
        long ans=0;
        long[] prefixSum=new long[N];
        for(int i=0;i<nums.length;i++){
            long sum=0;
            for(int j=i;j<nums.length;j++){
                sum=(sum+nums[j])%mod;
                prefixSum[k++]=sum;
            }
        }
        Arrays.sort(prefixSum);
        for(int i=left-1;i<=right-1;i++){
            ans=(ans+prefixSum[i])%mod;
        }
        return (int)(ans%mod);
    }
}