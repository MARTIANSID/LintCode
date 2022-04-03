class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=n-2;
        
        while(index >=0 && nums[index] >= nums[index+1])index--;
        
        
        int swapIndex=0;
        
        if(index<0){
            reverse(nums,0);
        }else{
            for(int i=n-1;i>index;i--){
                if(nums[i]>nums[index]){
                    swapIndex=i;
                    break;
                }
            }
            
            swap(nums,swapIndex,index);
            reverse(nums,index+1);
        }
        
        
        
    
    }
    
    public void reverse(int[] arr,int start){
        
        int i=start,j=arr.length-1;
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}