class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;   
        Arrays.sort(arr);
        arr[0]=1;
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]>1){
                arr[i+1]=arr[i]+1;
            }
        }
         
        
        
        return arr[n-1];
    }
}