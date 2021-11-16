class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n=nums.length;
        int[] freq=new int[n];
        
        for(int i=0;i<requests.length;i++){
            int start=requests[i][0];
            int end=requests[i][1];
            
            freq[start]++;
            
            if(end+1<nums.length)
            freq[end+1]--;
        }
        long[] origFreq=new long[n];
        long sum=0;
        
        for(int i=0;i<n;i++){
            sum+=freq[i];
            origFreq[i]=sum;
        }
        
        Arrays.sort(origFreq);
        Arrays.sort(nums);
        
        sum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            sum=(sum+(origFreq[i]*nums[i])%mod)%mod;
        }
        
        return (int)sum;
    }
}