class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ei=0,si=0,n=nums.length,sum=0,max=0;
            
            HashMap<Integer,Integer> map=new HashMap<>();
            
            
          while(ei<n){
                  sum+=nums[ei];
                 map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);
                 ei++;
                  
                  while(map.get(nums[ei-1])>1){
                         if(map.get(nums[si])==1){
                                 
                                 map.remove(nums[si]);
                         }else{
                                 map.put(nums[si],map.get(nums[si])-1);
                         }
                          sum-=nums[si];
                          
                          si++;
                          
                  }
                  
                max=  Math.max(max,sum);
                 
                  
          }
            return max;
    }
}