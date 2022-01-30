class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        
        
        int ones=0;
        for(int ele:nums){
            ones+=ele==1?1:0;
        }
        
        if(ones==0)return 0;
        
        int min=(int)1e9;
      
        int si=0,ei=0,one=0;
        while(ei<2*n){
            one+=nums[ei%n];
            ei++;
            if(ei-si==ones){
                min=Math.min(min,ei-si-one);
                one-=nums[si%n];
                si++;
            }
        }
        
        
        
        return min;
    }
}