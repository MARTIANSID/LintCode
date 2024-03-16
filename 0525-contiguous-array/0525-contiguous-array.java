class Solution {
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;
        
        HashMap<Integer ,Integer> map = new HashMap<>();
        
        map.put(0,-1);
        
        int sum = 0,max = 0;
        
        for(int i=0;i<n;i++){
            
            if(nums[i] == 0){
                sum+=-1;
            }else{
                sum+=nums[i];
            }
            
            if(map.containsKey(sum)){
                max = Math.max(max,i-map.get(sum));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            
        }
        return max;
    }
}