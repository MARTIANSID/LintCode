class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        
        long sum=0;
        
        for(int ele:nums){
            sum+=ele;
        }
        
        long rem=sum%p;
        
        if(rem==0)return 0;
        
        HashMap<Long,Integer> map=new HashMap<>();
        map.put((long)0,-1);
        
        long currSum=0;
        int min=n;
        
        for(int i=0;i<n;i++){
            currSum+=(long)nums[i];
            if(map.containsKey((currSum-rem)%p)){
                min=Math.min(min,i-map.get((currSum-rem)%p));
            }
            
            map.put(currSum%p,i);
        }
        
        return min==n?-1:min;
        
        
    }
}