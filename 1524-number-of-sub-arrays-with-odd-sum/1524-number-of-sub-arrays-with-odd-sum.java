class Solution {
    int mod=(int)1e9+7;
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        
        //find subarrays giving remainder as 1
        
        // HashMap<Long,Long> map=new HashMap<>();
        long[] prefix=new long[2];
        
        
        prefix[0]=(long)1;
        
        int sum=0;
        long count=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int rem=(sum-1)%2;
            
        count=(count+prefix[rem])%mod;
            prefix[(sum%2)]++;
        }
        
        return (int)(count%mod);
        
    }
}