class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.


    //sort colors logic 
    public void threeWayPartition(int arr[], int a, int b)
    {
        int low=0,high=0,n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]>=a){
                low=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]<=b)
            {
                high=i;
                break;
            }
        }
        
        
        for(int i=0;i<arr.length;i++){
            
            while(low<n&&arr[low]<a){
                low++;
            }
            while(high>=0&&arr[high]>b){
                high--;
            }
            
            if(arr[i]>b&&i<high){
                swap(i,high,arr);
                high--;
            }
            
            if(arr[i]<a&&i>low){
                swap(i,low,arr);
                low++;
            }
            
            
        }
        
        
        
    }
    
    public void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}