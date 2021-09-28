class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIndex=0;
        int oddIndex=1;
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) {
                ans[evenIndex]=nums[i];
                evenIndex+=2;
            }else{
                ans[oddIndex]=nums[i];
                oddIndex+=2;
            }
        }
        return ans;
    }
}