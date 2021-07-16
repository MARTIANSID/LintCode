class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int k=nums.length-1;k>=0;k--){
            int j=k-1;
            int i=0;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    ans+=j-i;
                     j--;
                }else{
                    i++;
                }
                
            }
        }
        
        return ans;
    }
}


// [2,3,4,4]
// 