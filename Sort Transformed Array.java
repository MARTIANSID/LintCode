public class Solution {
    /**
     * @param nums: a sorted array
     * @param a: 
     * @param b: 
     * @param c: 
     * @return: a sorted array
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        // Write your code here
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=(a*nums[i]*nums[i])+(b*nums[i])+c;
        }

        int i=0,j=n-1;
        int[] ans=new int[n];
        int o=n-1;
        int l=0;
        while(j>=i){
           if(a>=0){
             if(nums[j]>nums[i]){
                ans[o--]=nums[j];
                j--;
             }else{
                 ans[o--]=nums[i];
                 i++;

             }
             
            }else{

                if(nums[j]>nums[i]){
                ans[l++]=nums[i];
                i++;
             }else{
                 ans[l++]=nums[j];
                 j--;
             }



           }
        }

        return ans;

    }
}
