class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
            HashMap<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            int sum=0,ans=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
               
                int r=sum%k;
                  if(r<0&&r!=0)r=r+k;
                if(map.containsKey(r)){
                      int val=  map.get(r); 
                       ans+=val;
                        map.put(r,val+1);
                }else{
                        map.put(r,1);
                }
            }
            return ans;
    }
}