class Solution {
    
    class pair{
        int[] arr;
        int count;
        pair(int[] arr,int count){
            this.arr=arr;
            this.count=count;
        }
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        
        return solve(nums,0,n-1).count;
    }

    public pair solve(int[] nums, int si, int ei) {
        
        if(si==ei){
            pair p=new pair(new int[]{nums[si]},0);
            return p;
        }
        
        int mid = (ei + si) / 2;

        pair left = solve(nums, si, mid);
        pair right = solve(nums, mid + 1, ei);
        int[] l = left.arr;
        int[] r = right.arr;

        int n1 = l.length, n2 = r.length, i = 0, j = 0, count = 0;

        while (i < n1 && j < n2) {
            if ((long)l[i] > (long)(2 *(long)r[j])) {
                count += (n1 - i);
                j++;
            } else {
                i++;
            }
        }
        int totalCount = count + left.count + right.count;

        int n3 = n1 + n2;
        int[] arr3 = new int[n3];
        mergeArrays(l, r, n1, n2, arr3);
        
        pair p=new pair(arr3,totalCount);
        
        return p;
    }

    public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) arr3[k++] = arr1[i++]; else arr3[k++] = arr2[j++];
        }

        while (i < n1) arr3[k++] = arr1[i++];

        while (j < n2) arr3[k++] = arr2[j++];
    }
}
