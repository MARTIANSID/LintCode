class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        
        int prev=arr[0];
        for(int i=1;i<n;i++){
            if(prev<arr[i] && arr[i+1]<arr[i])return i;
        }
        return -1;
    }
    
}