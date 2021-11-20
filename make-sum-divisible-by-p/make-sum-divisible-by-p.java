class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        
        HashMap<Long,Integer> map=new HashMap<>();
        
        map.put((long)0,-1);
        
        
        long sum=0;
        long[] prefix=new long[n];
        int index=0;
        for(int ele:nums){
            sum+=ele;
            prefix[index++]=sum;
            
        }
        
        long  rem=(sum)%p;
        int length=(int)1e9;
        
        if(rem==0)return 0;
        
        long h=sum;
        sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(map.containsKey((sum-rem)%p)){
                long s=-1;
                if(map.get((sum-rem)%p)!=-1)
                 s=prefix[i]-prefix[map.get((sum-rem)%p)];
                else
                    s=sum;
                if(h-s<p)continue;

                length=Math.min(length,i-map.get((sum-rem)%p));
            }
            map.put(sum%p,i);
            
        }
        
        if(length==n)return -1;
        
        return length==(int)1e9?-1:length;
        
    }
}