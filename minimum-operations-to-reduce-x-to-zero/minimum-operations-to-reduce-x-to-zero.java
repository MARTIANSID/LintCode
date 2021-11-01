class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        HashMap<Long,Integer> map=new HashMap<>();
        
        long sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum==x)return n;
        long req=sum-x,currSum=0;                        
        map.put((long)0,-1);
        int max=-(int)1e9;
        for(int i=0;i<n;i++){
            currSum+=nums[i];
            if(map.containsKey(currSum-req)){
                max=Math.max(max,i-map.get(currSum-req));
            } 
            if(!map.containsKey(currSum)){
                map.put(currSum,i);
            }
        }
      if(max==-(int)1e9)return -1;
        return n-max;
    }
}


