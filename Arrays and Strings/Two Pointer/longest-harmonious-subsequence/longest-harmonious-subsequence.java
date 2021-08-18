class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=1;
        int max=0;
        while(i<=j&&j<nums.length){
            int diff=nums[j]-nums[i];
            
            if(diff==1){
                max=Math.max(max,j-i+1);
                j++;
            }else if(diff<1){
                j++;
            }else{
                i++;
            }
        }
        return max==1?0:max;
    }
}