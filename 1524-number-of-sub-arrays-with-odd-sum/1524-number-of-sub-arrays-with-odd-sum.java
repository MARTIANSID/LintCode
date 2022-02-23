class Solution {
    int mod=(int)1e9+7;
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        
        //find subarrays giving remainder as 1
        
        HashMap<Long,Long> map=new HashMap<>();
        map.put((long)0,(long)1);
        
        long  sum=0,count=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            long rem=(sum-1)%2;
            if(map.containsKey(rem)){
                count=(count+map.get(rem))%mod;
            }
            map.put(sum%2,map.getOrDefault(sum%2,(long)0)+1);
        }
        
        return (int)(count%mod);
        
    }
}