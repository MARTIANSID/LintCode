class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length,sum=0;
        
        for(int ele:nums){
            sum+=ele;
        }
        
        if(sum == x)return n;
        
        int alt=sum-x;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        
        int rSum=0,max=-1;
        
        for(int i=0;i<n;i++){
            rSum+=nums[i];
            int reqSum=rSum-alt;
            if(map.containsKey(reqSum)){
                max=Math.max(max,i-map.get(reqSum));
            }
            if(!map.containsKey(rSum))map.put(rSum,i);
        }
        
        return max == -1 ? -1 : n-max;
        
    }
}




