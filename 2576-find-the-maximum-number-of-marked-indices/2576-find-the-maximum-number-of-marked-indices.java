class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int marks=0,n=nums.length,i=0,j=n/2;
        Arrays.sort(nums);
        
        while(i<n/2 && j<n){
            int left=nums[i],right=nums[j];
            if(left*2<=right){
                marks+=2;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return marks;

    }
}



