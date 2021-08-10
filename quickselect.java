
public class quickselect {

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int left, int right, int pIndex) {
        int pivotEle = nums[pIndex];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivotEle) {
                i = i + 1;
                swap(i, j, nums);
            }

        }
        swap(i + 1, pIndex, nums);
        return i + 1;
    }

    // mid can be the kth smallest value that we need to find,or we can pass the mid
    // of the array to get median
    public int quickselect(int[] nums, int left, int right, int mid) {
        if (left == right) {
            return nums[left];
        }
        // pIndex is my privot index after passing it in the partition index i will get
        // the actual position of this element in an sorted array
        int pIndex = right;
        pIndex = partition(nums, left, right, pIndex);

        if (pIndex == mid)
            return nums[pIndex];

        if (pIndex > mid)
            return quickselect(nums, left, pIndex - 1, mid);

        else
            return quickselect(nums, pIndex + 1, right, mid);

    }

    public static void main(String[] args) {

    }
}
