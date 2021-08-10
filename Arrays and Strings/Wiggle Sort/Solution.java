public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {

        for(int i=0;i<nums.length-1;i++){
                if(i%2==0){
                    if(nums[i+1]<nums[i]){
                        swap(i+1,i,nums);
                    }
                }else{
                    if(nums[i+1]>nums[i]){
                        swap(i+1,i,nums);
                    }
                }
        }
        
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}