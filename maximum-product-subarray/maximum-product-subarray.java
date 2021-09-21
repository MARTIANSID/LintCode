class Solution {

    // o(n) tc , // o(n) space
    public int maxProduct(int[] nums) {

        int[] pre = new int[nums.length];
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 0)
                count++;
            if (nums[i] == 0)
                count = 0;
            pre[i] = count;
        }

        int p = 1, m = -(int) 1e9;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                p *= nums[i];
            else
                p = 1;
            arr[i] = p;
            m = Math.max(m, nums[i]);

        }
        int mp = m;
        boolean pos = true;
        int index = (int) 1e9;
        int prod = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {

                mp = Math.max(0, mp);

                pos = true;
                index = (int) 1e9;
                prod = 1;
            } else {
                if (nums[i] < 0) {

                    if (pos == false) {
                        prod *= nums[i];
                        mp = Math.max(mp, prod);
                        pos = true;

                        index = Math.min(index, i);
                    } else {
                        if (i + 1 < nums.length && pre[i + 1] != 0) {
                            prod *= nums[i];

                            pos = false;

                            index = Math.min(index, i);
                        } else {

                            if (index != (int) 1e9) {

                                mp = Math.max(mp, arr[i] / arr[index]);
                                prod = arr[i] / arr[index];

                            } else {
                                prod = 1;

                            }

                            pos = true;
                        }
                    }

                } else {
                    prod *= nums[i];
                    mp = Math.max(mp, prod);

                }
            }

        }

        return mp;

    }
    // o(n) , o(1) space
//keep max subarry ending at i and min subarray ending at i,for each value of i,as two minimums can produce the largest product9i
//modified of kdanes algo
    public int mp(int[] nums) {

        int max = -(int) 1e9;
        int maxEndingAti = 1;
        int minEndingAti = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(0, max);
                maxEndingAti = 1;
                minEndingAti = 1;
            }
            int mx = maxEndingAti;
            int mi = minEndingAti;
            maxEndingAti = Math.max(nums[i], Math.max(nums[i] * mx, nums[i] * mi));
            minEndingAti = Math.min(nums[i], Math.min(nums[i] * mx, nums[i] * mi));
            max = Math.max(max, maxEndingAti);
        }

        return max;
    }

}
