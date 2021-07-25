class Solution {
    public boolean canThreePartsEqualSum(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%3!=0)return false;
        int count1 =0,ans=0;
        int s=sum/3;
        sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
          if(sum==s){
              sum=0;
              ans++;
          }
        }
    
        if(ans>=3)return true;
        return false;
     
        
    }
}