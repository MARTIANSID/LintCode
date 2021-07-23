class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length,currSum=0;
        int[] left=new int[n];
        int[] right=new int[n];
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            left[i]=currSum;
        }
        currSum=0;
        for(int i=n-1;i>=0;i--){
            currSum+=nums[i];
            right[i]=currSum;
        }
        int[] result=new int[n];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                int  x=right[i+1];
                int ans=(x-(n-1)*nums[i]);
                result[i]=ans;
            }else if(i==n-1){
                int x=left[i-1];
                int ans=((n-1)*nums[i]-x);
                                result[i]=ans;

            }else{
                int x=right[i+1];
                int y=left[i-1];
                int ans=(x- (n-i-1)*nums[i] +  i*nums[i]-y);
                result[i]=ans;

            }
        }
        return result;
       
    }
}