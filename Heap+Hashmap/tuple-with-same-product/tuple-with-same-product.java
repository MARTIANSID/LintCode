class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int ans=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(map.containsKey(nums[i]*nums[j])){
                    ans+=map.get(nums[i]*nums[j])*8;
                }
                
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        
        return ans;
        
    
    }
}