class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length,max=0;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int ele:nums){
            map.put(ele,1);
        }
        
        HashSet<Integer> set=new HashSet<>();
        
        
        for(int ele:nums){
            int count=0;
            
            if(!map.containsKey(ele) || set.contains(ele))continue;
            
    
            int o=ele;
            
            while(map.containsKey(ele+1)){
                count+=map.get(ele+1);
                map.remove(ele+1);
                ele=ele+1;
            }
            
            map.put(o,count+1);
            max=Math.max(max,count+1);
            set.add(o);
        }
        return max;
    }
}