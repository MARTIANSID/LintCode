class Solution {
    public int maxOperations(int[] nums, int k) {
        int n=nums.length;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        
        for(int ele:nums){
            int findVal=k-ele;
            if(map.containsKey(findVal)){
                ans++;
                int x=map.get(findVal);
                x--;
                if(x==0)map.remove(findVal);
                else map.put(findVal,x);
            }else{
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
        }
        return ans;
    }
}