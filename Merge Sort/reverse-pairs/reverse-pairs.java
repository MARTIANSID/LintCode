class Solution {
    int count=0;
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;
    }
    
    
    public int[] mergeSort(int[] nums,int si,int ei){
        
        if(si==ei){
             int[]  temp=new int[1];
            temp[0]=nums[si];
            return temp;
        }
        
        int mid=(si+ei)/2;
        
      int[] y=  mergeSort(nums,mid+1,ei);
      int[] x=  mergeSort(nums,si,mid);
        
    int i=0,j=0,n1=x.length,n2=y.length;
        
        while(i<n1&&j<n2){
            // if(y[j]==Integer.MAX_VALUE)break;
            
        Long k=new Long(y[j]);
            
            k=2*k;
            
            
            if(x[i]>k){
                count+=(n1-i);
                j++;
            }else{
                i++;
            }
        }
        
        
        int[] z=new int[n1+n2];
        merge(x,y,z);
        return z;
        
    }
    
    public void merge(int[] arr1,int[] arr2,int[] arr3){
        int n1=arr1.length,n2=arr2.length,n3=arr3.length;
        
         int i = 0, j = 0, k = 0;
     
     
        while (i<n1 && j <n2)
        {
          
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
     
      
        while (i < n1)
            arr3[k++] = arr1[i++];
     

        while (j < n2)
            arr3[k++] = arr2[j++];
        
        
    }
}














// [1,3,2,3,1]
// 1,3   1,2,3










