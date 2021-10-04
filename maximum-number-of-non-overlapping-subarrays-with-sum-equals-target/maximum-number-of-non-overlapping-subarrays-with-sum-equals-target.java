class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
      
        
        
        int prev=-1,ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
         map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-target)){
              int x= map.get(sum-target);
                if(x+1>prev){
                    ans++;
                    prev=i;
                }
            }
            
            map.put(sum,i);
        }
        return ans;
    }
}