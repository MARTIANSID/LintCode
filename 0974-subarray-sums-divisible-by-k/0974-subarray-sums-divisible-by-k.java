class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0,ans=0;
        map.put(0,1);
        
        for(int ele:nums){
            sum+=ele;
            int rem=sum%k;
            if(rem<0){
                rem+=k;
            }
            ans+=map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}