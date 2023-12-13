class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int si=0,ei=0,max=0;
        
        while(ei<n){
            int ele=nums[ei++];
            map.put(ele,map.getOrDefault(ele,0)+1);
            
            if(map.get(ele)>k){
                while(true){
                    ele=nums[si++];
                    map.put(ele,map.get(ele)-1);
                    if(map.get(ele) == k)break;
                    if(map.get(ele)==0)map.remove(ele);
                }
            }
            max=Math.max(max,ei-si);
        }
        return max;
    }
}