class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m-1, j = n-1; // i = end element of nums1 (before zero) , j = last index of nums2
        
        int len = m + n - 1; // last index
        
        while(i >= 0 && j >= 0){
            
            if(nums1[i] >= nums2[j]){
                nums1[len] = nums1[i];
                i--;
                len--;
            } else {
                nums1[len] = nums2[j];
                j--;
                len--;
            }
            
        }
        
        while(j>=0){
            nums1[len] = nums2[j];
            len--;
            j--;
        }
        
    }
}


// nums1 = [2,3,5,6]  num2 = [1,2,3]
// nums1 = [1,2,2,3,5,6], m = 3, nums2 = [], n = 3


