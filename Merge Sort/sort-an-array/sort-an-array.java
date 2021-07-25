class Solution {
    public int[] sortArray(int[] nums) {
        
        
        return mergeSort(nums,0,nums.length-1);
        
    }
    
    public int[] mergeSort(int[] nums,int si,int ei){
        if(si==ei){
            int[] x=new int[1];
            x[0]=nums[si];
            return x;
        }
        int mid=(si+ei)/2;
     int[] left=   mergeSort(nums,si,mid);
      int[] right=  mergeSort(nums,mid+1,ei);
        
        int n1=left.length;
        int n2=right.length;
        int[] merged=new int[n1+n2];
        merge(left,right,merged);
        return merged;
    }
    
    public void merge(int[] left,int[] right,int[] merged){
        int n1=left.length;
        int n2=right.length;
        int n3=merged.length;
        int k=0,i=0,j=0;
        
        while(i<n1&&j<n2){
            if(left[i]<right[j]){
                merged[k++]=left[i];
                i++;
            }else{
                merged[k++]=right[j];
                j++;
            }
        }
        
        while(i<n1){
            merged[k++]=left[i++];
            
        }
        
        while(j<n2){
            merged[k++]=right[j++];
        }
    }
}