class Solution {
    
    /*
        [1,4,2,5,3]
        [1,4]
        [1,4,2]
        [1,4,2,5]
        [1,4,2,5,3]
        [4]
        [4,2]
        [4,2,5]
        [4,2,5,3]
*/
    
    
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length,sum=0;
        
        for(int i=0;i<n;i++){
             int oddLengthSubArraysIncludingThisElement=(((i+1)*(n-i)+1)/2);
            sum+=(oddLengthSubArraysIncludingThisElement*arr[i]);
        }
        return sum;
        
    }
}