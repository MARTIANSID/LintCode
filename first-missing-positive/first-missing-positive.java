class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
            
           for(int i=0;i<nums.length;i++){
                   map.put(nums[i],1);
           }
            
            boolean missing=true;
            int j=1;
            int ans=-1;
            while(missing){
                  missing = map.containsKey(j);
                   ans=j;
             j++;       
            }
            return ans;
    }
}