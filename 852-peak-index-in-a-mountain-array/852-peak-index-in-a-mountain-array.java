class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;

        //logN

        int si = 0, ei = n - 1;

        while (si <= ei) {
            int mid = (ei + si) / 2;

            if (mid - 1 >= 0 && mid + 1 < n && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid; else if (mid + 1 < n && arr[mid] < arr[mid + 1]) si = mid + 1; else {
                ei = mid - 1;
            }
        }
        return si;
    }
}
