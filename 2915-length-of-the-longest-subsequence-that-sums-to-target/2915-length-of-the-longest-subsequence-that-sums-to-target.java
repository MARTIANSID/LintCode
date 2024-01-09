class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        
        int n = nums.size();
        
     
        
        HashMap<Integer,Integer> map = new HashMap<>();  // sum : freq
        
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> temp=new HashMap<>();
            for(int j=0;j<=target;j++){
                int sum = j;
                int valReq = sum - nums.get(i);
        
                if(map.containsKey(valReq)){
                    int len = map.get(valReq);
                    temp.put(sum,Math.max(map.getOrDefault(sum,0),len+1));
                } 
            }
            
            for(int key : temp.keySet()){
                map.put(key,Math.max(temp.get(key),map.getOrDefault(key,0)));
            }
            
            map.put(nums.get(i),Math.max(map.getOrDefault(nums.get(i),0),1));
            
        }
        

        
        return map.containsKey(target) ? map.get(target) : -1;
    }
}

